import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class SignalGenerator implements Runnable {

	private SourceDataLine line;
	private Thread thread;
	private final int bufSize = 16 * 8192; // in bit
	private byte[] data = new byte[bufSize / 8];
	static private int fs = 48000;

	public SignalGenerator() {
		AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, fs, 16, 1, (16 / 8) * 1, fs, false);
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		if (!AudioSystem.isLineSupported(info)) {
			shutDown("Line matching " + info + " not supported.");
			return;
		}
		// get and open the source data line for playback
		try {
			line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(format, bufSize);
		} catch (LineUnavailableException ex) {
			shutDown("Unable to open the line: " + ex);
			return;
		}
		// start the source data line
		line.start();
		start();
	}

	public void start() {
		thread = new Thread(this);
		thread.setName("Playback");
		thread.setPriority(5);
		thread.start();
	}

	public void stop() {
		thread = null;
	}

	public void run() {
		while (thread != null) {
			double[] x = getSignal(data.length / 2);
			for (int i = 0; i < data.length / 2; i++) {
				data[2 * i] = (byte) (((short) x[i] & 0x00ff));
				data[2 * i + 1] = (byte) (((short) x[i] & 0xff00) >> 8);
			}
			line.write(data, 0, data.length);
		}
		line.stop();
		line.close();
		line = null;
		shutDown(null);
	}

	private void shutDown(String message) {
		if (message != null) {
			System.err.println(message);
		}
		if (thread != null) {
			thread = null;
		}
	}

	double[] waveForm;
	double freq, time;

	public void setWaveForm(double[] waveForm) {
		this.waveForm = waveForm;
	}

	public void setFrequency(double freq) {
		this.freq = freq;
	}

	private double[] getSignal(int length) {
		// waveForm.length muss eine 2er Potenz sein!
		double[] signal = new double[length];
		if (waveForm == null)
			return signal;
		for (int i = 0; i < signal.length; i++) {
			signal[i] = 16384 * waveForm[((int) Math.round(waveForm.length * time * freq)) & (waveForm.length - 1)];
			time += 1.0 / fs;
		}
		if (time > 1.0 / freq)
			time -= 1.0 / freq;
		return signal;
	}

	static double f = 0.0, s = 0.25;
	static double phi = 0.0, dphi = 0.0;
	static double[] b = new double[0], a = new double[0];

	public void setFourier(double[] b, double[] a, double f, double s) {
		SignalGenerator.f = f;
		SignalGenerator.b = b;
		SignalGenerator.a = a;
		SignalGenerator.s = s;
		dphi = 2.0 * Math.PI * (f / fs);
	}

	public static double[] fourierWave(int length) {
		double[] signal = new double[length];

		for (int i = 0; i < signal.length; i++) {
			for (int k = 0; (k < Math.min(b.length, 20)) && ((k + 1) * f < fs / 2); k++) {
				signal[i] += 0.5 * s * b[k] * (32767.0 * Math.cos((k + 1) * phi + 2.0 * Math.PI * a[k] / 360.0));
			}
			phi += dphi;
		}
		phi %= 2.0 * Math.PI;

		return signal;
	}

	public double[] squareWave(int length, double dutyCycle) {
		double[] s = new double[length];
		double T = 1 / f;

		for (int i = 0; i < s.length; i++) {
			if ((t + T) % T < dutyCycle * T) {
				s[i] = 0.5 * 32767.0;
			} else {
				s[i] = -0.5 * 32767.0;
			}
			t += 1.0 / fs;
		}
		t %= T;

		return s;
	}

	double f0 = 12e3, f1 = 20e3, sweepTime = 60.0, t;

	public double[] sweep(int length) {
		double[] s = new double[length];
		double beta = (f1 - f0) / sweepTime;

		for (int i = 0; i < s.length; i++) {
			s[i] = 0.5 * (32767.0 * Math.cos(1.0 * Math.PI * (f0 + beta * t) * t));
			t += 1.0 / fs;
			if (t > sweepTime) {
				t = 0;
			}
		}

		return s;
	}

	public double[] sinewav(int length) {
		double[] s = new double[length];

		for (int i = 0; i < s.length; i++) {
			s[i] = 0.5 * (32767.0 * Math.sin(2.0 * Math.PI * f * t));
			t += 1.0 / fs;
		}
		if (t > 1 / f) {
			t -= 1 / f;
		}

		return s;
	}

	public static void main(String s[]) {
		SignalGenerator signalGenerator = new SignalGenerator();
		signalGenerator.setFourier(new double[] { 1.0 }, new double[] { 0.0 }, 12e3, 0.5);
	}

}

import javax.swing.*;


public class View extends JFrame {
	
	public View(){
		JPanel panel = new JPanel();
		SearchableComboBox searchableComboBox = new SearchableComboBox();
		panel.add(searchableComboBox);
		this.add(panel);
		int[] x = {1,3,5,7,15};
		for(int i : x){
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		View view = new View();
		view.setVisible(true);
	}
}

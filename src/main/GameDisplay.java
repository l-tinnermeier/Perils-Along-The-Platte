package main;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPanel;

public class GameDisplay {

	private JFrame frame;
	private JLabel fileTextDisp;

	public static ArrayList<WeatherEvent> weatherEvents = new ArrayList<>();
	
	public int totalMiles = 0;
	public int goalMiles = 1000;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameDisplay window = new GameDisplay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public GameDisplay() throws Exception {
		initialize();
		parseEventInfo();
		fileTextDisp.setText(weatherEvents.get(0).getDesc());
		
		int day = 0;
		while(totalMiles <= goalMiles) {
			day++;
			System.out.println("Day " + day + ": " + generateEvent());
		}

		System.out.println("You made it in " + day + " days!");
	}
	
	private String generateEvent() {
		Random random = new Random();
		int eventRandomNum = random.nextInt(100) + 1;
		//System.out.println(eventRandomNum);
		
		String returnVal = "";
		for (int i = 0; i < weatherEvents.size(); i++) {
			if (weatherEvents.get(i).getFreqMin() <= eventRandomNum && eventRandomNum <= weatherEvents.get(i).getFreqMax()) {
				returnVal = weatherEvents.get(i).getDesc();
				
				switch(weatherEvents.get(i).getName()) {
					case "Default":
						totalMiles += 10;
						break;
					case "Thunderstorm":
						totalMiles += 1;
						break;
					case "Flood":
						totalMiles += 0;
						break;
				}
				break;
			}
		}
		
		return returnVal;
	}
	private void parseEventInfo() throws Exception{
		FileRead.reader();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(169, 169, 169));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		fileTextDisp = new JLabel("New label");
		fileTextDisp.setBackground(new Color(94, 94, 94));
		fileTextDisp.setForeground(new Color(0, 0, 0));
		fileTextDisp.setHorizontalAlignment(SwingConstants.CENTER);
		fileTextDisp.setBounds(135, 83, 179, 106);
		frame.getContentPane().add(fileTextDisp);
	}
}

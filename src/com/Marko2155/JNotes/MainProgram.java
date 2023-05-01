package com.Marko2155.JNotes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

class MainProgram {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton button = new JButton("Click here to add a tab");
		JTabbedPane tabs = new JTabbedPane();
		JMenuBar mb = new JMenuBar();
		JMenu menu1 = new JMenu("File");
		JMenu lastmenu = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save (currently does not work)");
		JMenuItem exit = new JMenuItem("Exit");
		JEditorPane field = new  JEditorPane();
		JFileChooser filechooser = new JFileChooser();
		filechooser.setSelectedFile(new File(System.getProperty("user.home")));
		
		//Add component settings here
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method 
				JEditorPane tabTextField = new JEditorPane();
				JScrollPane tabScroller = new JScrollPane(tabTextField);
				tabs.addTab("Tab", tabScroller);
			}
			
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				System.exit(0);
			}
			
		});
		
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = filechooser.showOpenDialog(menu1);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = filechooser.getSelectedFile();
					BufferedReader in;
					try {
						JEditorPane importedtabTextField = new JEditorPane();
						JScrollPane importedtabScroller = new JScrollPane(importedtabTextField);
						tabs.addTab("ImportedTab", importedtabScroller);
						in = new BufferedReader(new FileReader(selectedFile));
						String line = in.readLine();
						while(line != null) {
							importedtabTextField.setText(line + "\n");
							line = in.readLine();
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch(IOException e2) {
						e2.printStackTrace();
					}
				}
			}
			
		});
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result2 = filechooser.showSaveDialog(menu1);
			}
			
		});
		
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(frame, "Made by Marko2155\nFor people that frequently make notes.\nBuild 1523", "About", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		//Add menu bar items here
		mb.add(menu1);
		mb.add(lastmenu);
		//Add menu items here
		menu1.add(open);
		menu1.add(save);
		menu1.add(exit);
		lastmenu.add(about);
		//Add manual tabs here
		tabs.addTab("+", button);
		//Add components here
		frame.add(tabs);
		//Window settings here
		frame.setSize(800, 600);
		frame.setJMenuBar(mb);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setTitle("JNotes");
		frame.setIconImage(null);
	}
}

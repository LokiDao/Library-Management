package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import util.CONSTANTS;
import util.Validator;

public class Main {
	public static JFrame frame;
	
	public Main() {
		frame = new JFrame();
		frame.setSize(CONSTANTS.WIDTH, CONSTANTS.HEIGHT);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.setMenu();
		this.setContent();
		
		frame.setVisible(true);
	}
	
	private void setMenu() {
		JMenuItem listOrders = new JMenuItem("List Orders");
		listOrders.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {new ListOrder(null);}});
		
		JMenuItem newOrder = new JMenuItem("New Order");
		newOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {new AddOrder();}});
		
		JMenuItem listBooks = new JMenuItem("List Books");
		listBooks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {new ListBook(null);}});
		
		JMenuItem newBook = new JMenuItem("New Book");
		newBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {new AddBook();}});
		
		JMenuItem listMember = new JMenuItem("List Members");
		listMember.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {new ListMembers(null);}});
		
		JMenuItem newMember = new JMenuItem("New Member");
		newMember.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {new AddMember();}});
		
		JMenu orderMenu = new JMenu("Orders");
		orderMenu.add(listOrders);
		orderMenu.add(newOrder);
		
		JMenu bookMenu = new JMenu("Books");
		bookMenu.add(listBooks);
		bookMenu.add(newBook);
		
		JMenu memberMenu = new JMenu("Members");
		memberMenu.add(listMember);
		memberMenu.add(newMember);
		
		JMenuBar mainMenuBar = new JMenuBar();
		mainMenuBar.add(orderMenu);
		mainMenuBar.add(bookMenu);
		mainMenuBar.add(memberMenu);
		
		frame.setJMenuBar(mainMenuBar);
	}
	
	private void setContent() {
		Container mainContent = frame.getContentPane();
		
		FlowLayout layout = new FlowLayout();
		mainContent.setLayout(layout);
		
		JLabel welcome = new JLabel();
		Dimension size = welcome.getPreferredSize();
		welcome.setText("Welcome to Library Management System!");
		welcome.setBounds(150, 100, size.width, size.height);
		
//		JPanel panel = new JPanel();
//		panel.setLayout(null);
//	    panel.add(welcome);
//	    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	    mainContent.add(welcome);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}
}

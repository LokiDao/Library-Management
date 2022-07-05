package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.MemberController;
import dto.Member;
import util.Validator;

public class UpdateMember extends Container implements ActionListener {
	JLabel id;
	JTextField name;
	JTextField dob;
	JTextField gender;
	JLabel errorMsg;
	Member mem;
	MemberController controller;
	
	public UpdateMember(Member mem) {
		this.mem = mem;
		this.initScreen();
	    this.setNameValidation();
	    this.setDoBValidation();
	    this.setGenderValidation();
	    
	    Main.frame.setVisible(true);
	}
	
	public UpdateMember(String id) {
		System.out.println(id);
		controller = new MemberController();
		this.mem = controller.get(id);
		this.initScreen();
	    this.setNameValidation();
	    this.setDoBValidation();
	    this.setGenderValidation();
	    
	    Main.frame.setVisible(true);
	}
	
	private void initScreen() {
		Container content = Main.frame.getContentPane();
		content.removeAll();
		Main.frame.setVisible(true);
		
		if(this.mem == null) this.mem = new Member();
		
		JLabel idLabel = new JLabel("Member ID");
		id = new JLabel(this.mem.getId());
		JLabel nameLabel = new JLabel("Member Name");
		name = new JTextField(20);
		name.setText(this.mem.getName());
		JLabel dobLabel = new JLabel("Date of Birth");
		dob = new JTextField(20);
		dob.setText(this.mem.getDoB());
		JLabel genderLabel = new JLabel("Gender");
		gender = new JTextField(20);
		gender.setText(this.mem.getGender());
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(this);
		
		errorMsg = new JLabel();
		errorMsg.setForeground(Color.RED);
		
		JPanel panel = new JPanel();	
		panel.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(5, 0, 0, 5);

	    c.gridx = 1;
	    c.gridy = 1;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(idLabel, c);
	    
	    c.gridx = 2;
	    c.gridy = 1;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(id, c);
	    
	    c.gridx = 1;
	    c.gridy = 2;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(nameLabel, c);
	    
	    c.gridx = 2;
	    c.gridy = 2;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(name, c);
	    
	    c.gridx = 1;
	    c.gridy = 3;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(dobLabel, c);
	    
	    c.gridx = 2;
	    c.gridy = 3;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(dob, c);
	    
	    c.gridx = 1;
	    c.gridy = 4;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(genderLabel, c);
	    
	    c.gridx = 2;
	    c.gridy = 4;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(gender, c);
	    
	    c.gridx = 1;
	    c.gridy = 5;
	    c.anchor = GridBagConstraints.SOUTH;
	    panel.add(errorMsg, c);
	    
	    c.gridx = 2;
	    c.gridy = 6;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(submit, c);
	    
	    content.add(panel);
	}
	
	private void setNameValidation() {
		name.getDocument().addDocumentListener(new DocumentListener()
	    {
	      @Override
	      public void removeUpdate(DocumentEvent e)
	      {
	    	  if(!Validator.isSet(name.getText())) {
	    		  errorMsg.setText("Name cannot be blank.");
	    		  name.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }

	      @Override
	      public void insertUpdate(DocumentEvent e)
	      {
	    	  if(!Validator.isSet(name.getText())) {
	    		  errorMsg.setText("Name cannot be blank.");
	    		  name.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }

	      @Override
	      public void changedUpdate(DocumentEvent e) {
	    	  if(!Validator.isSet(name.getText())) {
	    		  errorMsg.setText("Name cannot be blank.");
	    		  name.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }
	    });
	}
	
	private void setDoBValidation() {
		dob.getDocument().addDocumentListener(new DocumentListener()
	    {
	      @Override
	      public void removeUpdate(DocumentEvent e)
	      {
	    	  if(Validator.isSet(dob) && !Validator.isDate(dob.getText())) {
	    		  errorMsg.setText("Wrong date format");
	    		  dob.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }

	      @Override
	      public void insertUpdate(DocumentEvent e)
	      {
	    	  if(Validator.isSet(dob) && !Validator.isDate(dob.getText())) {
	    		  errorMsg.setText("Wrong date format");
	    		  dob.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }

	      @Override
	      public void changedUpdate(DocumentEvent e) {
	    	  if(Validator.isSet(dob) && !Validator.isDate(dob.getText())) {
	    		  errorMsg.setText("Wrong date format");
	    		  dob.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }
	    });
	}
	
	private void setGenderValidation() {
		gender.getDocument().addDocumentListener(new DocumentListener()
	    {
	      @Override
	      public void removeUpdate(DocumentEvent e)
	      {
	    	  if(Validator.isSet(gender) && !Validator.isGender(gender.getText())) {
	    		  errorMsg.setText("Gender is incorrect.");
	    		  gender.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }

	      @Override
	      public void insertUpdate(DocumentEvent e)
	      {
	    	  if(Validator.isSet(gender) && !Validator.isGender(gender.getText())) {
	    		  errorMsg.setText("Gender is incorrect.");
	    		  gender.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }

	      @Override
	      public void changedUpdate(DocumentEvent e) {
	    	  if(Validator.isSet(gender) && !Validator.isGender(gender.getText())) {
	    		  errorMsg.setText("Gender is incorrect.");
	    		  gender.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }
	    });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!Validator.isSet(id.getText())) {
	  		  errorMsg.setText("ID cannot be blank.");
	  		  id.requestFocus();
  	  	} else if(!Validator.isNumber(id.getText())) {
	  		  errorMsg.setText("ID must be a number.");
	  		  id.requestFocus();
  	  	} else if(!Validator.isSet(name.getText())) {
	  		  errorMsg.setText("Name cannot be blank.");
	  		  name.requestFocus();
  	  	} else if(Validator.isSet(dob) && !Validator.isDate(dob.getText())) {
	  		  errorMsg.setText("Wrong date format");
	  		  dob.requestFocus();
  	  	} else if(Validator.isSet(gender) && !Validator.isGender(gender.getText())) {
	  		  errorMsg.setText("Gender is incorrect.");
	  		  gender.requestFocus();
  	  	} else {
  	  	controller = new MemberController();
			this.mem.sets(name.getText(), dob.getText(), gender.getText());
			int rs = controller.update(mem);
			String msg = null;
        	if(rs == -3) msg = "An error occured.";
        	else if(rs == -2) msg = "Data source is still not opened yet.";
        	else if(rs == -1) msg = "Member " + this.mem.getId() + " does not exist.";
        	else if(rs == 0) msg = "There is no data provided.";
        	else if(rs == 1) msg = "Member " + this.mem.getId() + " has been updated.";
        	else msg = "Unkow error";
        	JOptionPane.showMessageDialog(null, msg);
			if(rs == 1) new ListMembers(msg);
  	  	}
	}
}

package com.springboot;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestApp extends JFrame {

	private static final long serialVersionUID = 1L;

	public TestApp() {

		initUI();
	}

	private void initUI() {

		JTextField tf = new JTextField("Hello");

		JButton quitButton = new JButton("Quit");

		quitButton.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});

		createLayout(tf, quitButton);

		setTitle("Quit button");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createLayout(JComponent... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(arg[0]));
		// gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(arg[1]));

		gl.setVerticalGroup(gl.createSequentialGroup().addComponent(arg[0]));
		// gl.setVerticalGroup(gl.createSequentialGroup().addComponent(arg[1]));
	}

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(TestApp.class).headless(false).run(args);

		EventQueue.invokeLater(() -> {
			TestApp ex = ctx.getBean(TestApp.class);
			ex.setVisible(true);
		});
	}
}

package de.erdesignerng.visual;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ERDesignerGettingStartedFrame
{
    ERDesignerMainFrame frame;
    JFrame getStartedFrame;
    JButton getStarted;
    JButton no;
    JLabel textLabel;

    public ERDesignerGettingStartedFrame(ERDesignerMainFrame mainframe) {
		frame = mainframe;
        getStartedFrame = new JFrame();
        JPanel p = new JPanel();

		textLabel = new JLabel("Hello Welcome To Mogwai ERDesigner!");
		textLabel.setSize(400,100);

		getStarted = new JButton("Get Started");
        getStarted.addActionListener(new startButtonListener());
		no = new JButton("No, Thanks");
        no.addActionListener(new closeButtonListener());

		p.add(textLabel);
		p.add(getStarted);
		p.add(no);

        getStartedFrame.getContentPane().add(p);
    }

    public void displayFrame()
    {
        getStartedFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getStartedFrame.setPreferredSize(new Dimension(400, 200));
        getStartedFrame.pack();
        getStartedFrame.setVisible(true);
    }

    public class startButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            getStartedFrame.setVisible(false);
            ERDesignerGettingStartedTutorial tutorial = new ERDesignerGettingStartedTutorial(frame);
            tutorial.showTutorialPopup();
        }
    }

    public class closeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            getStartedFrame.dispose();
        }
    }
}
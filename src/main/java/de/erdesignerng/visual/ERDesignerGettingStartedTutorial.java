package de.erdesignerng.visual;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ERDesignerGettingStartedTutorial {

    Popup p;
    PopupFactory pf;
    ERDesignerMainFrame frame;
    
    ERDesignerGettingStartedTutorial(ERDesignerMainFrame mainframe) {
        pf = new PopupFactory();
        frame = mainframe;
    }

    public void showTutorialPopup() {
        String[] steps = {"1. Click Database and make connection", 
                          "2. Add Entity (add attribute atleast one)",
                          "3. Add another entity and make relation", 
                          "4. Add another atribute to existing entity by double click it",
                          "5. Save your model after work on it",
                          "6. To load existing model, you can click"};
        int[][] position = {{100,100}, {200,200}, {300,300}, {400,400},{300,500},{400,600}};
        JPanel[] panels = new JPanel[steps.length];
        JPanel endPanel = endPanel();
        for (int i = steps.length - 1; i >= 0 ; i--) {
            if (i == steps.length - 1) {
                panels[i] = stepPanel(steps[i], endPanel, 500, 250);
            }
            else {
                panels[i] = stepPanel(steps[i], panels[i+1], position[i+1][0], position[i+1][1]);
            }
        }
        showPopup(panels[0], position[0][0], position[0][1]);
    }

    public void showPopup(JPanel panel, int x, int y) {
        panel.setVisible(true);
        p = pf.getPopup(frame, panel, x, y);
		p.show();
    }

    public JPanel stepPanel(String step, JPanel nextPanel, int nextPanelPosX, int nextPanelPosY) {
        JPanel stepPanel = new JPanel();
		JLabel stepLabel = new JLabel(step);
		stepLabel.setHorizontalAlignment(JLabel.CENTER);
		stepLabel.setVerticalAlignment(JLabel.CENTER);
		stepLabel.setSize(400,100);

		JButton next = new JButton("Next");
        next.addActionListener(new nextButtonListener(stepPanel, nextPanel, nextPanelPosX, nextPanelPosY));
		stepPanel.add(stepLabel);
		stepPanel.add(next);

        return stepPanel;
    }

    public JPanel endPanel() {
        JPanel endPanel = new JPanel();
		JLabel endLabel = new JLabel("Finish!");
		endLabel.setHorizontalAlignment(JLabel.CENTER);
		endLabel.setVerticalAlignment(JLabel.CENTER);
		endLabel.setSize(400,100);

		JButton finish = new JButton("Close Tutorial");
        finish.addActionListener(new finishButtonListener(endPanel));
		endPanel.add(endLabel);
        endPanel.add(finish);

        return endPanel;
    }

    public class nextButtonListener implements ActionListener {

        JPanel currJPanel;
        JPanel nextJPanel;
        int nextXPos;
        int nextYPos;

        nextButtonListener(JPanel panel, JPanel nextPanel, int nextPanelPosX, int nextPanelPosY) {
            currJPanel = panel;
            nextJPanel = nextPanel;
            nextXPos = nextPanelPosX;
            nextYPos = nextPanelPosY;
        }

        public void actionPerformed(ActionEvent event) {
            currJPanel.setVisible(false);
            p.hide();
            showPopup(nextJPanel, nextXPos, nextYPos);
        }
    }

    public class finishButtonListener implements ActionListener {

        JPanel currJPanel;

        finishButtonListener(JPanel currPanel) {
            currJPanel = currPanel;
        }

        public void actionPerformed(ActionEvent event) {
            currJPanel.setVisible(false);
            p.hide();
        }
    }

}

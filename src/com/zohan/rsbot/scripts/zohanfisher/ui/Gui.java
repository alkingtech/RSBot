package com.zohan.rsbot.scripts.zohanfisher.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.MethodProvider;

import com.zohan.rsbot.scripts.zohanfisher.ZohanFisher;
import com.zohan.rsbot.scripts.zohanfisher.data.Fish;
import com.zohan.rsbot.scripts.zohanfisher.data.Location;
import com.zohan.rsbot.scripts.zohanfisher.task.Dropping;
import com.zohan.rsbot.scripts.zohanfisher.task.Fishing;

public class Gui extends MethodProvider {

	private JPanel contentPane;
	private JFrame jf = new JFrame();
	private Location loc;

	/**
	 * Create the frame.
	 */
	public Gui(final MethodContext ctx, final ZohanFisher zf) {
		super(ctx);
		jf.setTitle("Zohan Fisher");
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		jf.setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 262);
		contentPane.add(tabbedPane);

		JLayeredPane fishingPane = new JLayeredPane();
		tabbedPane.addTab("Spot/Fish", null, fishingPane, null);

		final JComboBox locationSelect = new JComboBox();
		locationSelect.setModel(new DefaultComboBoxModel(Location.values()));
		locationSelect.setBounds(100, 11, 122, 20);
		fishingPane.add(locationSelect);

		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLocation.setBounds(10, 14, 80, 17);
		fishingPane.add(lblLocation);

		final JComboBox fishSelect = new JComboBox();
		fishSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Fish fish = (Fish) fishSelect.getSelectedItem();
				zf.fish = fish;
			}
		});
		fishSelect.setBounds(100, 42, 122, 20);
		fishingPane.add(fishSelect);

		locationSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				loc = (Location) locationSelect.getSelectedItem();
				zf.location = loc;
				fishSelect.setModel(new DefaultComboBoxModel(loc.getFish()));
			}
		});

		loc = (Location) locationSelect.getSelectedItem();
		fishSelect.setModel(new DefaultComboBoxModel(loc.getFish()));

		JLabel lblFish = new JLabel("Fish");
		lblFish.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFish.setBounds(10, 44, 46, 14);
		fishingPane.add(lblFish);

		JCheckBox chckbxBanking = new JCheckBox("Banking");
		chckbxBanking.setEnabled(false);
		chckbxBanking.setBackground(Color.WHITE);
		chckbxBanking.setBounds(10, 69, 97, 23);
		fishingPane.add(chckbxBanking);

		JCheckBox chckbxUrns = new JCheckBox("Urns");
		chckbxUrns.setBackground(Color.WHITE);
		chckbxUrns.setEnabled(false);
		chckbxUrns.setBounds(10, 90, 97, 23);
		fishingPane.add(chckbxUrns);

		JCheckBox chckbxActionbar = new JCheckBox("Actionbar Dropping Key\"1\"");
		chckbxActionbar.setBackground(Color.WHITE);
		chckbxActionbar.setEnabled(false);
		chckbxActionbar.setBounds(10, 111, 212, 23);
		fishingPane.add(chckbxActionbar);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						zf.taskmanager().add(
								new Fishing(ctx, zf.fish.getId(), zf.fish
										.getInteract()));
						zf.taskmanager().add(new Dropping(ctx));
						zf.guiReady();
						jf.dispose();
			}
		});
		btnStart.setBounds(10, 183, 130, 40);
		fishingPane.add(btnStart);

		JLayeredPane uniquePane = new JLayeredPane();
		tabbedPane.addTab("Unique Modes", null, uniquePane, null);

		JComboBox comboUnique = new JComboBox();
		comboUnique.setBounds(10, 11, 123, 20);
		uniquePane.add(comboUnique);

		JButton btnStartUnique = new JButton("Start");
		btnStartUnique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnStartUnique.setBounds(10, 183, 123, 40);
		uniquePane.add(btnStartUnique);
		jf.setVisible(true);
	}
}

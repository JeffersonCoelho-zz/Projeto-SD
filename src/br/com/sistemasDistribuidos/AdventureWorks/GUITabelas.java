package br.com.sistemasDistribuidos.AdventureWorks;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class GUITabelas extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private ArrayList<Integer> products;
	private HashMap<Integer, ArrayList> productStatus;
	private DefaultTableModel tableJProducts;
	private DefaultTableModel tableJStatus;
	private IAdventureWorks adventureWorks;

	public GUITabelas() {
	}

	public GUITabelas(IAdventureWorks adventureWorks) {
		initComponents();
		updateLayout();
		this.adventureWorks = adventureWorks;
		products = new ArrayList<>();
		initJTables();
		initArrayProducts();
		updateJTableProducts();
		updateJTableStatus();
	}

	private void initJTables() {
		tableJProducts = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableJProducts.addColumn("Codigo");

		tableJStatus = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableJStatus.addColumn("Codigo");
		tableJStatus.addColumn("Status");
		tableJStatus.addColumn("Telefone");
	}

	private void initArrayProducts() {
		Integer randomNum;

		for (int i = 0; i < 10; i++) {
			randomNum = 1000 + (int) (Math.random() * 100000);
			products.add(randomNum);
		}
	}

	private void updateJTableProducts() {
		tableJProducts.setRowCount(0);
		if (products.isEmpty()) {
			tableJProducts.addRow(new String[] { "Não tem informações" });
		} else {
			for (int i = 0; i < products.size(); i++) {
				tableJProducts.addRow(new String[] { String.valueOf(products.get(i)), "Aberto" });
			}
		}
		tableProducts.setModel(tableJProducts);

	}

	private void updateJTableStatus() {
		tableJStatus.setRowCount(0);
		try {
			productStatus = adventureWorks.listRequest();
		} catch (RemoteException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		if (productStatus.isEmpty()) {
			tableJStatus.addRow(new String[] { "Não tem informações", "Sem informações", "Sem informações" });
		} else {
			productStatus.entrySet().forEach((entry) -> {
				Integer key = entry.getKey();
				ArrayList value = entry.getValue();
				tableJStatus.addRow(new String[] { String.valueOf(key), "Aberto", value.get(1).toString() });
			});
		}
		tableStatus.setModel(tableJStatus);
	}

	private void updateLayout() {
		this.setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		updateProducts = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableProducts = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		tableStatus = new javax.swing.JTable();
		updateStatus = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		registerProducts = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		updateProducts.setText("Atualizar");
		updateProducts.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AtualizarProdutosActionPerformed(evt);
			}
		});

		tableProducts.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null }, { null }, { null }, { null } }, new String[] { "Codigo" }) {
			boolean[] canEdit = new boolean[] { false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(tableProducts);

		tableStatus.setModel(
				new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null } }, new String[] { "Codigo", "Status", "Telefone" }) {
					boolean[] canEdit = new boolean[] { false, false, false };

					public boolean isCellEditable(int rowIndex, int columnIndex) {
						return canEdit[columnIndex];
					}
				});
		tableStatus.setEnabled(false);
		jScrollPane2.setViewportView(tableStatus);

		updateStatus.setText("Atualizar");
		updateStatus.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Atualizar_SituacaoActionPerformed(evt);
			}
		});

		jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
		jLabel3.setText("Produtos");

		jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
		jLabel4.setText("Situação do Produto");

		registerProducts.setText("Cadastrar");
		registerProducts.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CadastrarProdutosActionPerformed(evt);
			}
		});

		jLabel5.setBackground(new java.awt.Color(0, 102, 102));
		jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(102, 204, 255));
		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel5.setText("ADVENTURE WORKS ");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(108, 108, 108).addComponent(jLabel3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel4).addGap(205, 205, 205))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(17, 17, 17)
												.addComponent(registerProducts, javax.swing.GroupLayout.PREFERRED_SIZE,
														103, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(updateProducts,
														javax.swing.GroupLayout.PREFERRED_SIZE, 98,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 32, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addComponent(updateStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 206,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(140, 140, 140))))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap()
								.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(jLabel5).addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jLabel4))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(updateStatus).addComponent(updateProducts).addComponent(registerProducts))
				.addContainerGap(25, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened

	}// GEN-LAST:event_formWindowOpened

	private void AtualizarProdutosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_AtualizarProdutosActionPerformed
		updateJTableProducts();

	}// GEN-LAST:event_AtualizarProdutosActionPerformed

	private void Atualizar_SituacaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Atualizar_SituacaoActionPerformed
		updateJTableStatus();
	}// GEN-LAST:event_Atualizar_SituacaoActionPerformed

	private void CadastrarProdutosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CadastrarProdutosActionPerformed
		String id = JOptionPane.showInputDialog("Informe o ID que deseja abrir o processo: ");

		if (id != null) {
			if (this.products.contains(Integer.parseInt(id))) {

				String phone = JOptionPane
						.showInputDialog("Para completar a requisição, digite seu número de telefone: ");

				if (phone != null) {
					try {
						adventureWorks.sendRequest(Integer.parseInt(id), phone);
						products.remove(id);
					} catch (RemoteException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}

			} else {
				JOptionPane.showMessageDialog(null, "Esse ID não existe na lista, por gentileza tente novamente!");
			}
		}

	}// GEN-LAST:event_CadastrarProdutosActionPerformed

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(() -> {
			new GUITabelas().setVisible(true);
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton updateProducts;
	private javax.swing.JButton updateStatus;
	private javax.swing.JButton registerProducts;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable tableProducts;
	private javax.swing.JTable tableStatus;
	// End of variables declaration//GEN-END:variables
}

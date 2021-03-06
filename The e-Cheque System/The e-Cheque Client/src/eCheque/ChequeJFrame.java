/*
 * ChequeJFrame.java
 *
 * Created on May 4, 2007, 2:31 AM
 *
 *
 * @author  Saad
 */

package eCheque;

//import com.Trendy.swing.plaf.TrendyLookAndFeel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import java.security.*;
import javax.crypto.Cipher;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import javax.swing.JFileChooser;


public class ChequeJFrame extends javax.swing.JFrame {

	/** Creates new form ChequeJFrame */
	private EChequeRegistration eChequeReg;
	private boolean newChequeFlag;
	private boolean loadChequeFlag = false;
	private String signPass;
	private ECheque oldCheque;
	
	
	public ChequeJFrame(EChequeRegistration registerUser) {
		/*try {
		//TrendyLookAndFeel tlf = new TrendyLookAndFeel();
		//tlf.setCurrentTheme( new com.Trendy.swing.plaf.Themes.TrendyOrangeTheme());
		//UIManager.setLookAndFeel(tlf);
		}
		catch(Exception e) {
		//JOptionPane.showMessageDialog(null,"System Error", "can not found themes", JOptionPane.ERROR_MESSAGE);
		}*/
		initComponents();
		eChequeReg = registerUser;
		
		// set new cheque status false;
		newChequeFlag = false;
	}
	
	
	/** This method is called from within the constructor to
	  * initialize the form.
	  * WARNING: Do NOT modify this code. The content of this method is
	  * always regenerated by the Form Editor.
	  */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jDSignCheque = new javax.swing.JDialog();
		jPanel6 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTuserSign = new javax.swing.JPasswordField();
		jBOK = new javax.swing.JButton();
		jBCancel = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jLDrawerName = new javax.swing.JLabel();
		jLDate = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLSerialNumber = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		jTPayTo = new javax.swing.JTextField();
		jPanel4 = new javax.swing.JPanel();
		jTAmount = new javax.swing.JTextField();
		jPanel5 = new javax.swing.JPanel();
		jLBankName = new javax.swing.JLabel();
		jLAccountNum = new javax.swing.JLabel();
		jCGranteed = new javax.swing.JCheckBox();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jTYear = new javax.swing.JTextField();
		jTMonth = new javax.swing.JTextField();
		jTDay = new javax.swing.JTextField();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMNewCheque = new javax.swing.JMenuItem();
		jMOpenCheque = new javax.swing.JMenuItem();
		jMSaveCheque = new javax.swing.JMenuItem();
		jMVerifyCheque = new javax.swing.JMenuItem();
		jMExitChequeForm = new javax.swing.JMenuItem();

		jDSignCheque.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		jDSignCheque.setTitle("Sign Cheque");
		jDSignCheque.setAlwaysOnTop(true);
		jDSignCheque.setLocationByPlatform(true);
		jDSignCheque.setModal(true);
		jDSignCheque.setResizable(false);

		jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sign Cheque", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 51)));
		// NOI18N

		jLabel1.setText("Password:");

		jBOK.setText("OK");
		
		jBOK.addMouseListener(
			new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					jBOKMouseClicked(evt);
				}
			}
		);

		jBCancel.setText("Cancel");
		jBCancel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				 jBCancelMouseClicked(evt);
			}
		});

		org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(
			jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
					.addContainerGap()
					.add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
					.add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
						.add(jPanel6Layout.createSequentialGroup()
							.add(jBOK, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.add(jBCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.add(jTuserSign))
					.add(29, 29, 29))
		);
		jPanel6Layout.setVerticalGroup(
			jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
			.add(jPanel6Layout.createSequentialGroup()
				.addContainerGap()
				.add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
					.add(jLabel1)
					.add(jTuserSign, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
				.add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
					.add(jBOK)
					.add(jBCancel))
				.addContainerGap())
		);

		org.jdesktop.layout.GroupLayout jDSignChequeLayout = new org.jdesktop.layout.GroupLayout(jDSignCheque.getContentPane());
		jDSignCheque.getContentPane().setLayout(jDSignChequeLayout);
		jDSignChequeLayout.setHorizontalGroup(
			jDSignChequeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
			.add(jDSignChequeLayout.createSequentialGroup()
				.addContainerGap()
				.add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 274, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(40, Short.MAX_VALUE))
		);
		jDSignChequeLayout.setVerticalGroup(
			jDSignChequeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
			.add(jDSignChequeLayout.createSequentialGroup()
				.addContainerGap()
				.add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(36, Short.MAX_VALUE))
		);

	  setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	  setTitle("e-Cheque");
	  setResizable(false);
	  addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				close(evt);
			}
	  });

		jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Drawer Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); 
		// NOI18N
		jPanel2.setFont(new java.awt.Font("Times New Roman", 1, 12));

		org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
			.add(jPanel2Layout.createSequentialGroup()
				.add(jLDrawerName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
				.addContainerGap())
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
			.add(jLDrawerName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
		);

		jLDate.setFont(new java.awt.Font("Times New Roman", 1, 12));
		jLDate.setText("Date:");

		jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eCheque/resources/barcode.GIF"))); // NOI18N

		jLSerialNumber.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLSerialNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pay to the order of", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
		// NOI18N
		jPanel3.setFont(new java.awt.Font("Times New Roman", 1, 12));

		org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
			jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
			.add(jPanel3Layout.createSequentialGroup()
				.addContainerGap()
				.add(jTPayTo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
				.addContainerGap())
		);
		jPanel3Layout.setVerticalGroup(
			jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
			.add(jPanel3Layout.createSequentialGroup()
				.add(jTPayTo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Amount of Money", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0))); 
		// NOI18N

		org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(
			jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
			.add(jPanel4Layout.createSequentialGroup()
				.addContainerGap()
				.add(jTAmount, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
				.addContainerGap())
		);
		jPanel4Layout.setVerticalGroup(
			jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
			.add(jPanel4Layout.createSequentialGroup()
				.add(jTAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(13, Short.MAX_VALUE))
		);

		jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Banking Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
		// NOI18N

		jLBankName.setText("Bank Name:");

		jLAccountNum.setText("Account no:");

		org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(
			jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
			.add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel5Layout.createSequentialGroup()
				.addContainerGap()
				.add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
					.add(org.jdesktop.layout.GroupLayout.LEADING, jLAccountNum, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
					.add(org.jdesktop.layout.GroupLayout.LEADING, jLBankName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
				.addContainerGap())
		);
		jPanel5Layout.setVerticalGroup(
			jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
			.add(jPanel5Layout.createSequentialGroup()
				.add(jLBankName)
				.add(14, 14, 14)
				.add(jLAccountNum)
				.addContainerGap(12, Short.MAX_VALUE))
		);

		jCGranteed.setText("Granteed");
		jCGranteed.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jCGranteed.setMargin(new java.awt.Insets(0, 0, 0, 0));

		jLabel7.setText("Earn Date:");

		jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel8.setText("Y");

		jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel9.setText("M");

		jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel10.setText("D");

		org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
			.add(jPanel1Layout.createSequentialGroup()
				.add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
					.add(jPanel1Layout.createSequentialGroup()
							.addContainerGap()
							.add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
								.add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.add(jPanel1Layout.createSequentialGroup()
									.add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
								.add(jPanel1Layout.createSequentialGroup()
									.add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))))
					  .add(jPanel1Layout.createSequentialGroup()
							.add(32, 32, 32)
							.add(jCGranteed, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
				 .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
					  .add(jPanel1Layout.createSequentialGroup()
							.add(13, 13, 13)
							.add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
								.add(jLabel3, 0, 0, Short.MAX_VALUE)
								.add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
									.add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
											.add(jPanel1Layout.createSequentialGroup()
												.add(jLabel7)
												.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
												.add(jTYear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
											.add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
												.add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(26, 26, 26)))
									.add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
											.add(jTMonth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
											.add(jPanel1Layout.createSequentialGroup()
												.add(11, 11, 11)
												.add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
									.add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
											.add(jPanel1Layout.createSequentialGroup()
												.add(12, 12, 12)
												.add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
											.add(jPanel1Layout.createSequentialGroup()
												.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
												.add(jTDay, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
									.add(12, 12, 12))
								.add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
									.add(10, 10, 10)
									.add(jLSerialNumber, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
									.add(17, 17, 17))))
					.add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
							.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.add(jLDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
							.add(28, 28, 28)))
				.add(10, 10, 10))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
			
			.add(jPanel1Layout.createSequentialGroup()
			
				.addContainerGap()
				
				.add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				
					.add(jPanel1Layout.createSequentialGroup()
							.add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 16, Short.MAX_VALUE)
							.add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
							
					.add(jPanel1Layout.createSequentialGroup()
							.add(jLDate)
							.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
							.add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
							.add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel10)
								.add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(jLabel9))))
								
				 .add(0, 0, 0)
				 
				 .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
					.add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
							.add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel7)
								.add(jTYear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(jTMonth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(jTDay, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
							.add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
					.add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
					
				.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
				
				.add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
					.add(jCGranteed)
					.add(jLSerialNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
					
				.addContainerGap())
				
		);

		jMenu1.setText("Cheque");
		jMenu1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu1ActionPerformed(evt);
			}
		});

		jMNewCheque.setText("New");
		jMNewCheque.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMNewChequeActionPerformed(evt);
			}
		});
		jMenu1.add(jMNewCheque);

		jMOpenCheque.setText("Open");
		jMOpenCheque.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMOpenChequeActionPerformed(evt);
			}
		});
		jMenu1.add(jMOpenCheque);

		jMSaveCheque.setText("Save");
		jMSaveCheque.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMSaveChequeActionPerformed(evt);
			}
		});
		jMenu1.add(jMSaveCheque);

        jMVerifyCheque.setText("Verfiy");
        jMVerifyCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerifyChequeActionPerformed(evt);
            }
        });
        jMenu1.add(jMVerifyCheque);

        jMExitChequeForm.setText("Exit");
        jMExitChequeForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMExitChequeFormActionPerformed(evt);
            }
        });
        jMenu1.add(jMExitChequeForm);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-434)/2, (screenSize.height-340)/2, 434, 340);
    }// </editor-fold>//GEN-END:initComponents
	 
	 
	private void close(java.awt.event.WindowEvent evt) {
		//GEN-FIRST:event_close
		// TODO add your handling code here:
	}//GEN-LAST:event_close
	
	
	private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {
		//GEN-FIRST:event_jMenu1ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jMenu1ActionPerformed
	
	
	private void jMExitChequeFormActionPerformed(java.awt.event.ActionEvent evt) {
		//GEN-FIRST:event_jMExitChequeFormActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jMExitChequeFormActionPerformed
	
	
	private void jMVerifyChequeActionPerformed(java.awt.event.ActionEvent evt) {
		//GEN-FIRST:event_jMVerifyChequeActionPerformed
		// TODO add your handling code here:
		String certificatePath;
		
		if(loadChequeFlag){
			certificatePath = getFileLocation("Load Digital Certificate");   
			
			if(certificatePath.length() != 0) {
				// Get the cheque reference signature.
				String signatureReference = chequeReferenceString(oldCheque);
				// Create Digital Certificate Object for verification
				DigitalCertificate drawerDC;
				// Create Digital Certificate IO to load the Certificate
				DigitalCertificateIO readDC = new DigitalCertificateIO();
				// Create a Digital signature object.
				DigitalSignature verfiy = new DigitalSignature();
				
				try{
					boolean verfiySignature;
					
					drawerDC = (DigitalCertificate)readDC.readDigitalCertificate(certificatePath);
					verfiySignature = verfiy.verifySignature(oldCheque.getDrawerSignature(),  signatureReference, drawerDC.getPublicKey());

					if(verfiySignature){
						JOptionPane.showMessageDialog(null,"The signature is valid", "e-Cheque Clear",
						JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null,"The signature is not valid", "e-Cheque not Clear",
						JOptionPane.WARNING_MESSAGE);
					}
				}
				catch(Exception exp){
					JOptionPane.showMessageDialog(null,"Please load the drawer Digital Certificate", "User Error",
					JOptionPane.ERROR_MESSAGE);

				}
			}
			else{
				JOptionPane.showMessageDialog(null,"Please load the drawer Digital Certificate", "User Error",
				JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"Please first open an e-Cheque", "User Error",
			JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_jMVerifyChequeActionPerformed
		
		
	private void jBOKMouseClicked(java.awt.event.MouseEvent evt) {
		//GEN-FIRST:event_jBOKMouseClicked
		// TODO add your handling code here:
		char password[] = jTuserSign.getPassword();
		String passTemp = "";

		if((password.length >=8) && (password.length <16)) {
			for(int i=0; i<password.length; i++) {
				passTemp += password[i];
			}
			
			int pad = 16 - password.length; 
			
			for(int i=0; i<pad; i++){
				passTemp += password[i];
			}
		}
		signPass = passTemp;
		jDSignCheque.setVisible(false);
	}//GEN-LAST:event_jBOKMouseClicked
	
	
	private void jBCancelMouseClicked(java.awt.event.MouseEvent evt) {
		//GEN-FIRST:event_jBCancelMouseClicked
		// TODO add your handling code here:
		jDSignCheque.setVisible(false);
		this.setEnabled(true);
	}//GEN-LAST:event_jBCancelMouseClicked
	
	
	private void jMSaveChequeActionPerformed(java.awt.event.ActionEvent evt) {
		//GEN-FIRST:event_jMSaveChequeActionPerformed
		// TODO add your handling code here:
		String amount;
		String payTo;
		String day;
		String month;
		String year;
		boolean guaranteed = false;

		// get cheque info to save it.
		amount = jTAmount.getText();
		payTo = jTPayTo.getText();
		day = jTDay.getText();
		month = jTMonth.getText();
		year = jTYear.getText();

		if(jCGranteed.isSelected()){
			guaranteed = true;
		}

		// validate the cheque data before saving it
		if(newChequeFlag){
			if(amount.length()!=0){
				if(payTo.length()!=0){
					if((day.length()!=0) && (month.length()!=0) && (year.length()!=0)){
						// Ask the user to enter his password to sign the cheque with his private key
						getSignature();
						
						if(signPass.hashCode() == eChequeReg.getPasword()) {
							ECheque eCheque = new ECheque();
							
							try {                                    
								// Create AES Key with user password and cipher  
								AESCrypt aesCrypt = new AESCrypt();
								Key AES128 = aesCrypt.initializeAESKeyByPassword(signPass);
								Cipher cipher = aesCrypt.initializeCipher(AES128,1);
								InputStream inputStream = new FileInputStream(eChequeReg.getEWalletLocation() + "\\Security Tools\\Private Key.key");
								OutputStream outputStream = new FileOutputStream(eChequeReg.getEWalletLocation() + "\\Security Tools\\PrivateKey.key");

								// Decrypt the private key with the AES key and delete the plain key
								aesCrypt.crypt(inputStream, outputStream, cipher);
								inputStream.close();
								outputStream.close();

								ObjectInputStream objInputStream = new ObjectInputStream (new FileInputStream(eChequeReg.getEWalletLocation() + "\\Security Tools\\PrivateKey.key"));

								// Load the user private key.
								PrivateKey privateKey = (PrivateKey)objInputStream.readObject();
								objInputStream.close();

								// Delete the insecure key.
								File control = new File(eChequeReg.getEWalletLocation() + "\\Security Tools\\PrivateKey.key");
								control.delete();
								JOptionPane.showMessageDialog(null, "Load private key");

								// Fill the Cheque Data
								eCheque.setAccountNumber(eChequeReg.getAccountNumber());
								eCheque.setAccountHolder(eChequeReg.getClientName());
								eCheque.setBankName(eChequeReg.getBankName());
								eCheque.setChequeNumber(jLSerialNumber.getText());
								eCheque.setCurrencyType("US $");
								eCheque.setAmountOfMoney(jTAmount.getText());
								eCheque.setEarnDay(year + "," + month + "," + day);
								eCheque.setPayToOrderOf(payTo);
								eCheque.setGuaranteed(guaranteed);

								// Get cheque reference string and sign it.
								String chequeRef = chequeReferenceString(eCheque);
								DigitalSignature digitalSign = new DigitalSignature();
								eCheque.setDrawerSignature(digitalSign.signature(chequeRef, privateKey));
								JOptionPane.showMessageDialog(null, "Signing complete");

								//Save the cheque after you sign it
								EChequeIO drawCheque = new EChequeIO();
								drawCheque.saveCheque(eCheque, eChequeReg.getEWalletLocation() + "\\My Cheques\\"+ eCheque.getChequeNumber() + ".sec");
								JOptionPane.showMessageDialog(null, "Done");
							}
							catch(Exception exp) {
								// 'SYSTEM ERROR' IS NOT DESCRIPTIVE
								JOptionPane.showMessageDialog(null,exp.getMessage(),"System error",
								JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(null,"Password is incorrect","User Error",
							JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"Earn Date info missing","User Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Please specify the Cheque Receiver","User Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Cheque Amount is zero","User Error",
				JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"Please create a new cheque","User Error",
			JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_jMSaveChequeActionPerformed
	
	
	private void jMNewChequeActionPerformed(java.awt.event.ActionEvent evt) {
		//GEN-FIRST:event_jMNewChequeActionPerformed
		// Active cheque form
		jTAmount.setEditable(true);
		jTPayTo.setEditable(true);
		jTYear.setEditable(true);
		jTMonth.setEditable(true);
		jTDay.setEditable(true);
		jCGranteed.setEnabled(true);
		
		//set the user registeration data on the form
		jLDrawerName.setText(eChequeReg.getClientName());
		jLBankName.setText("Bank Name: " + eChequeReg.getBankName());
		jLAccountNum.setText("Account no: " + eChequeReg.getAccountNumber());
		
		//Generate the cheque serial number
		jLSerialNumber.setText(generateSerialNumber()); 
		
		//Set check issue date
		jLDate.setText("Date: " + currentDate());
		
		// clear any old data
		jTAmount.setText("");
		jTPayTo.setText("");
		jTDay.setText("");
		jTMonth.setText("");
		jTYear.setText("");
		jCGranteed.setSelected(false);
		
		newChequeFlag = true;
	}//GEN-LAST:event_jMNewChequeActionPerformed
	
	
	private void jMOpenChequeActionPerformed(java.awt.event.ActionEvent evt) {
		//GEN-FIRST:event_jMOpenChequeActionPerformed
		String chequePath;
		chequePath = getFileLocation("Open Cheque");

		if(chequePath.length() != 0) {
			oldCheque = new ECheque();
			EChequeIO loadCheque = new EChequeIO();
			
			try {
				// load cheque that already exists
				oldCheque = loadCheque.readCheque(chequePath);
				jLDrawerName.setText(oldCheque.getAccountHolder());
				jLBankName.setText("Bank Name: " + oldCheque.getBankName());
				jLAccountNum.setText("Account no: " + oldCheque.getAccountNumber());
				
				// get the earn date
				String []earnDate = oldCheque.getEarnDay().split(",");
				jTYear.setText(earnDate[0]);
				jTYear.setEditable(false);
				jTMonth.setText(earnDate[1]);
				jTMonth.setEditable(false);
				jTDay.setText(earnDate[2]);
				jTDay.setEditable(false);
				
				jTPayTo.setText(oldCheque.getPayToOrderOf());
				jTPayTo.setEditable(false);
				
				jTAmount.setText(oldCheque.getMoney());
				jTAmount.setEditable(false);
				
				if(oldCheque.getGuaranteed()) {
					jCGranteed.setSelected(true);
					jCGranteed.setEnabled(false);
				}
				jLSerialNumber.setText(oldCheque.getChequeNumber());
				jLDate.setText("Date: " + currentDate());
				
				loadChequeFlag = true;
			}
			catch(Exception exp) {
				JOptionPane.showMessageDialog(null,"Invalid Cheque","Security Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
	}//GEN-LAST:event_jMOpenChequeActionPerformed
	
	
	private String getFileLocation(String filePath){
		
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(this);
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setDialogTitle(filePath);
		
		if (result == JFileChooser.CANCEL_OPTION) {
			return "";
		}
		
		File fileName = fileChooser.getSelectedFile();
		
		// Display error if file name is invalid
		if ((fileName == null ) || ( fileName.getName().equals( "" ))) {
			JOptionPane.showMessageDialog( this, "Blank file name entered", "Invalid File Name", JOptionPane.ERROR_MESSAGE );
			
			return "";
		}
		
		return fileName.getPath();
	}
	
	
	private String generateSerialNumber(){
		
		String serialNumber=""; 
		GregorianCalendar calender = new GregorianCalendar();
		
		serialNumber += calender.get(calender.DAY_OF_MONTH);
		serialNumber += calender.get(calender.MONTH);
		serialNumber += calender.get(calender.YEAR) + "  ";
		serialNumber += calender.get(calender.HOUR_OF_DAY);
		serialNumber += calender.get(calender.MINUTE) + " ";
		serialNumber += calender.get(calender.SECOND);
		serialNumber += calender.get(calender.MILLISECOND);
		
		return serialNumber;        
	}
	
	
	private String currentDate() {
		
		String currentDateInfo=""; 
		GregorianCalendar calender = new GregorianCalendar();
		
		currentDateInfo += calender.get(calender.DAY_OF_MONTH) + " - ";
		currentDateInfo += calender.get(calender.MONTH) + 1 + " - ";
		currentDateInfo += calender.get(calender.YEAR);
		
		return currentDateInfo;
	}
	
	
	private void getSignature() {
		signPass = "";
		java.awt.Dimension screenSize =java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		jDSignCheque.setBounds((screenSize.width - 300) / 2, (screenSize.height - 150) / 2, 300, 150); 
		jDSignCheque.setVisible(true);
	}
	
	
	private String chequeReferenceString(ECheque eCheque){
		String reference;
		reference = eCheque.getAccountNumber() + eCheque.getAccountHolder() + eCheque.getBankName();
		reference += eCheque.getChequeNumber() + eCheque.getMoney() + eCheque.getCurrencyType();
		reference += eCheque.getEarnDay() + eCheque.getGuaranteed() + eCheque.getPayToOrderOf();
		
		return reference;    
	}
	
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jBCancel;
	private javax.swing.JButton jBOK;
	private javax.swing.JCheckBox jCGranteed;
	private javax.swing.JDialog jDSignCheque;
	private javax.swing.JLabel jLAccountNum;
	private javax.swing.JLabel jLBankName;
	private javax.swing.JLabel jLDate;
	private javax.swing.JLabel jLDrawerName;
	private javax.swing.JLabel jLSerialNumber;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JMenuItem jMExitChequeForm;
	private javax.swing.JMenuItem jMNewCheque;
	private javax.swing.JMenuItem jMOpenCheque;
	private javax.swing.JMenuItem jMSaveCheque;
	private javax.swing.JMenuItem jMVerifyCheque;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JTextField jTAmount;
	private javax.swing.JTextField jTDay;
	private javax.swing.JTextField jTMonth;
	private javax.swing.JTextField jTPayTo;
	private javax.swing.JTextField jTYear;
	private javax.swing.JPasswordField jTuserSign;
	// End of variables declaration//GEN-END:variables
}

/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-7-20
 */
package com.mingrisoft.jfreechart.pie;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

public class PieDemo9 extends ApplicationFrame {

	public PieDemo9(String title) {
		super(title);
	}

	/**
	 * �إߤ@�ӻ�Ϫ���ƶ� ���ƼW�[���ƶ���
	 * 
	 * @return
	 */
	private PieDataset getPieDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();

		dataset.setValue("JAVA�q�J�����q�]��2���^", 500);
		dataset.setValue("���T��JAVA", 800);
		dataset.setValue("JAVA����t�d�_��", 1000);
		dataset.setValue("Java�d�ҧ����۾Ǥ�U(1DVD)", 400);
		dataset.setValue("Java�}�o�嫬�Ҷ��j��", 750);
		return dataset;
	}

	/**
	 * ��o��ƶ��A����JFreeChart�A
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		PieDataset dataset = getPieDataset();
		JFreeChart chart = ChartFactory.createPieChart3D("2010.8����P��Ʀ�",
				dataset, true, true, false);
		// �]�w��ϨϥΪ��r��
		setPiePoltFont(chart);
		return chart;
	}

	/**
	 * �]�w��ϨϥΪ��r��
	 * 
	 * @param chart
	 */
	protected void setPiePoltFont(JFreeChart chart) {

		// �����O���Ҧr��M���
		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setLabelFont(new Font("�ө���", Font.PLAIN, 14));
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}:{1}"));

		// ���D�r��
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("�ө���", Font.BOLD, 20));

		// �ϨҦr��
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("�ө���", Font.PLAIN, 14));

	}

	/**
	 * �]�wPie
	 * 
	 * @param chart
	 */
	public void createPiePlot() {
		JFreeChart chart = getJFreeChart();
		PiePlot3D plot = (PiePlot3D) chart.getPlot();

		ActionListener actionListener = new PieDemo9Listener(plot);
		// �W�[��ť
		Timer timer = new Timer(100, actionListener);
		//�Ұ�timer�ɶ���
		timer.start();

		// ��JFreeChart�ﹳ�x�s�쭱�O��
		setContentPane(new ChartPanel(chart));

	}

	public static void main(String[] args) {
		PieDemo9 pieChartDemo1 = new PieDemo9("��Ϲ��");
		// �إ߹ϧ�
		pieChartDemo1.createPiePlot();
		// ���͹ϧ�
		pieChartDemo1.pack();
		// �ⵡ����ܨ���ܾ���
		RefineryUtilities.centerFrameOnScreen(pieChartDemo1);
		// �]�w��ܹϧΪ��A
		pieChartDemo1.setVisible(true);

	}

}

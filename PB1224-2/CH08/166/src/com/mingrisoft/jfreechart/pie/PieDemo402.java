/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-7-20
 */
package com.mingrisoft.jfreechart.pie;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

public class PieDemo402 extends ApplicationFrame {

	public PieDemo402(String title) {
		super(title);
	}

	/**
	 * �إߤ@�ӻ�Ϫ���ƶ�
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
	 * ����JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		PieDataset dataset = getPieDataset();
		JFreeChart chart = ChartFactory.createPieChart("2010.8����P��Ʀ�", dataset,
				true, true, false);
		setPiePoltFont(chart);
		return chart;
	}

	/**
	 * �]�w��ϨϥΪ��r��
	 * 
	 * @param chart
	 */
	protected void setPiePoltFont(JFreeChart chart) {

		// �Ϫ�(���)
		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setLabelFont(new Font("�ө���", Font.PLAIN, 14));
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}:{1}"));

		// ���D
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("�ө���", Font.BOLD, 20));

		// �Ϩ�
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
		PiePlot piePlot = (PiePlot) chart.getPlot();
		
		//�]�w�����ت��C��
		piePlot.setSectionOutlinePaint("JAVA�q�J�����q�]��2���^", Color.black);
		piePlot.setSectionOutlinePaint("���T��JAVA", Color.black);
		piePlot.setSectionOutlinePaint("JAVA����t�d�_��", Color.black);
		piePlot.setSectionOutlinePaint("Java�d�ҧ����۾Ǥ�U(1DVD)", Color.black);
		piePlot.setSectionOutlinePaint("Java�}�o�嫬�Ҷ��j��", Color.black);

		// ��JFreeChart���O�x�s�b�����
		setContentPane(new ChartPanel(chart));

	}

	public static void main(String[] args) {
		PieDemo402 pieChartDemo1 = new PieDemo402("��Ϲ��");
		pieChartDemo1.createPiePlot();
		pieChartDemo1.pack();
		// �ⵡ����ܨ���ܾ�����
		RefineryUtilities.centerFrameOnScreen(pieChartDemo1);
		pieChartDemo1.setVisible(true);

	}
}

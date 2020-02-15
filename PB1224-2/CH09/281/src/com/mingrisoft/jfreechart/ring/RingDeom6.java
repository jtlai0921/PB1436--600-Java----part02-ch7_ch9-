package com.mingrisoft.jfreechart.ring;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * ���Ϊ����v����
 * @author baiweiming
 *
 */
public class RingDeom6 extends ApplicationFrame {

	public RingDeom6(String title) {
		super(title);
	}

	/**
	 * �إߤ@�Ӹ�ƶ�
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
		JFreeChart chart = ChartFactory.createRingChart("2010�W�b�~�P��O��", // �Ϫ���D
				dataset, // ��ƶ�
				true, // �O�_��ܹϨ�(���²�檺�W���ϥ����Ofalse)
				false, // �O�_���ͤu��
				false // �O�_����URL�챵
				);

		return chart;
	}

	/**
	 * �ק�r��
	 * 
	 * @param chart
	 */
	private void updateFont(JFreeChart chart) {

		// �Ϫ�
		RingPlot ringPlot = (RingPlot) chart.getPlot();
		ringPlot.setLabelFont(new Font("�ө���", Font.PLAIN, 14));
		ringPlot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}:{1}"));

		// ���D
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("�ө���", Font.PLAIN, 20));
		//�ϥ�
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("�ө���", Font.PLAIN, 14));

	}

	/**
	 * ��s�Ϫ����
	 * 
	 * @param chart
	 */
	private void updatePlot(JFreeChart chart) {
		// �Ϫ�
		RingPlot plot = (RingPlot) chart.getPlot();
		//���v����
		plot.setShadowXOffset(20);
		plot.setShadowYOffset(20);
	}

	/**
	 * �]�w�Ϫ�
	 * 
	 * @param chart
	 */
	public void createPlot() {
		JFreeChart chart = getJFreeChart();
		// �]�w�r��
		updateFont(chart);
		//�]�w�Ϫ�
		updatePlot(chart);
		// ��JFreeChart���O�x�s�b�����
		setContentPane(new ChartPanel(chart));

	}

	public static void main(String[] args) {
		RingDeom6 demo = new RingDeom6("���ι�");
		demo.createPlot();
		demo.pack();
		// �ⵡ����ܨ���ܾ�����
		RefineryUtilities.centerFrameOnScreen(demo);
		// �]�w�i�H���
		demo.setVisible(true);

	}

}

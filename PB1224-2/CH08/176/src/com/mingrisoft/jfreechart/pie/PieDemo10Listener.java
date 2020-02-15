/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-7-20
 */
package com.mingrisoft.jfreechart.pie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.plot.PiePlot;

public class PieDemo10Listener implements ActionListener {

	private PiePlot plot;

	//��Ϫ�����
	private int angle = 90;
	
	public PieDemo10Listener(PiePlot plot) {
		this.plot =plot;
	}
	
	/*
	 * �]�w��Ϫ����סA�V�k����h��1�A�p�G��Ϫ����״��0�ɡA�⨤�׭��s�]�w���O360
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed( ActionEvent event) {
		this.plot.setStartAngle(this.angle);
		this.angle = this.angle - 1;
		if (this.angle == 0) {
			this.angle = 360;
		}
	}

}

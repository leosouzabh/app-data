package br.com.app.model;

public class LabelValue {

	private String label;
	private Integer value;
	
	public LabelValue(String label, Integer value) {
		super();
		this.label = label;
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public void addValue() {
		this.value++;
	}
	
	
}
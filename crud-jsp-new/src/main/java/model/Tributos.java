package model;

public class Tributos {
	public Icms icms;
	public Pis pis;
	public Cofins cofins;

	public Tributos(Icms icms, Pis pis, Cofins cofins) {
		this.icms = icms;
		this.pis = pis;
		this.cofins = cofins;
	}
}

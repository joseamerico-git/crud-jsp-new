package model.veiculo;

public class Tributos {
	public Icms icms;
	public Pis pis;
	public Cofins cofins;

	public Tributos(Icms icms, Pis pis, Cofins cofins) {
		this.icms = icms;
		this.pis = pis;
		this.cofins = cofins;
	}

	public Icms getIcms() {
		return icms;
	}

	public void setIcms(Icms icms) {
		this.icms = icms;
	}

	public Pis getPis() {
		return pis;
	}

	public void setPis(Pis pis) {
		this.pis = pis;
	}

	public Cofins getCofins() {
		return cofins;
	}

	public void setCofins(Cofins cofins) {
		this.cofins = cofins;
	}
}

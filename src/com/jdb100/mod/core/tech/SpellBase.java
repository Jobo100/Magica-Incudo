package com.jdb100.mod.core.tech;

public class SpellBase extends SpiritBase
{
	
	SpiritBase spirit = new SpiritBase();
	
	private int[] xpPerTeir = new int[5];
	
	public SpellBase()
	{
		xpTeirs();
	}
	
	private void xpTeirs()
	{
		xpPerTeir[1] = 25;
		xpPerTeir[2] = 50;
		xpPerTeir[3] = 150;
		xpPerTeir[4] = 600;
		xpPerTeir[5] = 1000;
	}
	
	public void increaseCurrentXpByTeir(int teir)
	{
		int xp = spirit.getCurrentXp();
		spirit.setCurrentXp(xp + getXpPerTeir(teir));
		spirit.increaseLevel();
	}
	
	public int getXpPerTeir(int teir)
	{
		return xpPerTeir[teir];
	}
}

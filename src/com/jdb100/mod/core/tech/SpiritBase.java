package com.jdb100.mod.core.tech;

public class SpiritBase 
{
	
	
	public int level;
	public int currentXp;
	public int[] requiredXp = new int[50];
	public int mana;
	public int totalMana;
	public int[] manaAtLevel = new int[50];
	public int teir;
	public int[] requiredLevel = new int[10];
	
	
	public SpiritBase()
	{
		Teir();
		requiredXp();
		manaList();
	}
	
	public void increaseLevel()
	{
		int level = getLevel();
		if(currentXp >= requiredXp[level + 1])
		{
			setCurrentXp(currentXp - requiredXp[level + 1]);
			level++;
			setLevel(level);
			increaseTotalMana();
			increaseTeir();
			
		}
		
	}
	
	public void increaseTotalMana()
	{
		int level = getLevel();
		totalMana = manaAtLevel[level];
		mana = totalMana;
		
	}
	
	public void increaseTeir()
	{
		int level = getLevel();
		if(level == requiredLevel[1])
			setTeir(1);
		else if(level == requiredLevel[2])
			setTeir(2);
		else if(level == requiredLevel[3])
			setTeir(3);
		else if(level == requiredLevel[4])
			setTeir(4);
		else if(level == requiredLevel[5])
			setTeir(5);
	}

	public void decreaseMana(int amount)
	{
		int mana = getMana();
		mana = mana - amount;
		setMana(mana);
	}
	
	public void increaseMana(int amount)
	{
		int mana = getMana();
		mana = mana + amount;
		setMana(mana);
	}
	
	public void increaseCurrentXp(int amount)
	{
		int xp = getCurrentXp();
		xp = xp + amount;
		setCurrentXp(xp);
	}
	
	private void Teir()
	{
		requiredLevel[1] = 1;
		requiredLevel[2] = 15;
		requiredLevel[3] = 20;
		requiredLevel[4] = 30;
		requiredLevel[5] = 50;
	}
	
	private void requiredXp()
	{
		requiredXp[2] = 100;
		requiredXp[3] = 250;
		requiredXp[4] = 425;
		requiredXp[5] = 625;
		requiredXp[6] = 800;
		requiredXp[7] = 950;
		requiredXp[8] = 1075;
		requiredXp[9] = 1175;
		requiredXp[10] = 1250;
		requiredXp[11] = 1300;
		requiredXp[12] = 1325;
		requiredXp[13] = 1350;
		requiredXp[14] = 1450;
		requiredXp[15] = 1500;
		requiredXp[16] = 2500;
		requiredXp[17] = 3500;
		requiredXp[18] = 5000;
		requiredXp[19] = 7000;
		requiredXp[20] = 8500;
		requiredXp[21] = 10000;
		requiredXp[22] = 20000;
		requiredXp[23] = 35000;
		requiredXp[24] = 50000;
		requiredXp[25] = 65000;
		requiredXp[26] = 70000;
		requiredXp[27] = 90000;
		requiredXp[28] = 110000;
		requiredXp[29] = 121000;
		requiredXp[30] = 130000;
		requiredXp[31] = 150000;
		requiredXp[32] = 250000;
		requiredXp[33] = 400000;
		requiredXp[34] = 600000;
		requiredXp[35] = 800000;
		requiredXp[36] = 1000000;
		requiredXp[37] = 1200000;
		requiredXp[38] = 1400000;
		requiredXp[39] = 1600000;
		requiredXp[40] = 1800000;
		requiredXp[41] = 2000000;
		requiredXp[42] = 2300000;
		requiredXp[43] = 2600000;
		requiredXp[44] = 2900000;
		requiredXp[45] = 3200000;
		requiredXp[46] = 3500000;
		requiredXp[47] = 4000000;
		requiredXp[48] = 4500000;
		requiredXp[49] = 5000000;
		requiredXp[50] = 5500000;
	}
	
	private void manaList()
	{
		manaAtLevel[1] = 100;
		manaAtLevel[2] = 250;
		manaAtLevel[3] = 425;
		manaAtLevel[4] = 625;
		manaAtLevel[5] = 800;
		manaAtLevel[6] = 950;
		manaAtLevel[7] = 1075;
		manaAtLevel[8] = 1175;
		manaAtLevel[9] = 1250;
		manaAtLevel[10] = 1300;
		manaAtLevel[11] = 1325;
		manaAtLevel[12] = 1350;
		manaAtLevel[13] = 1450;
		manaAtLevel[14] = 1500;
		manaAtLevel[15] = 2500;
		manaAtLevel[16] = 3500;
		manaAtLevel[17] = 5000;
		manaAtLevel[18] = 7000;
		manaAtLevel[19] = 8500;
		manaAtLevel[20] = 10000;
		manaAtLevel[21] = 20000;
		manaAtLevel[22] = 35000;
		manaAtLevel[23] = 50000;
		manaAtLevel[24] = 65000;
		manaAtLevel[25] = 70000;
		manaAtLevel[26] = 90000;
		manaAtLevel[27] = 110000;
		manaAtLevel[28] = 121000;
		manaAtLevel[29] = 130000;
		manaAtLevel[30] = 150000;
		manaAtLevel[31] = 250000;
		manaAtLevel[32] = 400000;
		manaAtLevel[33] = 600000;
		manaAtLevel[34] = 800000;
		manaAtLevel[35] = 1000000;
		manaAtLevel[36] = 1200000;
		manaAtLevel[37] = 1400000;
		manaAtLevel[38] = 1600000;
		manaAtLevel[39] = 1800000;
		manaAtLevel[40] = 2000000;
		manaAtLevel[41] = 2300000;
		manaAtLevel[42] = 2600000;
		manaAtLevel[43] = 2900000;
		manaAtLevel[44] = 3200000;
		manaAtLevel[45] = 3500000;
		manaAtLevel[46] = 4000000;
		manaAtLevel[47] = 4500000;
		manaAtLevel[48] = 5000000;
		manaAtLevel[49] = 5500000;
		manaAtLevel[50] = 6000000;
	}
	
	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getMana() {
		return mana;
	}


	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getTeir() {
		return teir;
	}

	public void setTeir(int teir) {
		this.teir = teir;
	}

	public int getCurrentXp() {
		return currentXp;
	}
	
	public void setCurrentXp(int amount)
	{
		this.currentXp = amount;
	}
	
	public int getRequiredXp(int level)
	{
		return requiredXp[level];
	}
	public int getTotalMana()
	{
		return totalMana;
	}
	
	public void setTotalMana(int totalMana)
	{
		this.totalMana = totalMana;
	}
}

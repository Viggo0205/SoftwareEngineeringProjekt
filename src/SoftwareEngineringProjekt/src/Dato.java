// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

/*
 * 	uofficiel ugeberegning
 */


public class Dato {
	// Klassevariabler
	private int year, month, day, uge;

	// Konstruktører
	public Dato(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Dato(int uge, int year) {
		this.day = 1;
		this.month = 1;
		this.year = year;
		while ( uge > 1 )
		{
			this.day += 7;
			if (this.month < 8 )
			{
				if ( this.month % 2 == 1 )
				{
					if (this.day > 31)
					{
						this.month++;
						this.day -= 31;
					}
				}
				else if ( this.month == 2 )
				{
					if ( this.year % 4 == 0 && this.day > 29)
					{
						this.month++;
						this.day -= 29;
					}
					else if ( this.day > 28)
					{
						this.month++;
						this.day -= 28;
					}
				}
				else if ( this.day > 30 )
				{
					this.month++;
					this.day -= 30;
				}
			}
			else 
			{
				if ( this.month % 2 == 0 )
				{
					if (this.day > 31)
					{
						this.month++;
						this.day -= 31;
					}
				}
				else if (this.day > 30)
				{
					this.month++;
					this.day -= 30;
				}
			}
			uge--;
		}
	}

	public int getDeltaDag(Dato dag2) {
		int deltaDag = 0;
		int y = dag2.year;
		int m = dag2.month;
		int d = dag2.day;
		while (y != this.year)
		{
			if (y > this.year)
			{
				if ( y % 4 == 0 & m > 3 )
				{
					deltaDag += 366;
				}
				else
				{
					deltaDag += 365;
				}
				y--;
			}
			else
			{
				if (  y % 4 == 0 & m < 3 )
				{
					deltaDag -= 366;
				}
				else
				{
					deltaDag -= 365;
				}
				y++;
			}
		}

		while (m != this.month)
		{
			if (m > this.month)
			{
				if ( m <= 8 )
				{
					if ( m % 2 == 0 )
					{
						deltaDag += 31;
					}
					else if ( m == 3 )
					{
						if ( y % 4 == 0 )
							deltaDag += 29;
						else
							deltaDag += 28;
					}
					else
					{
						deltaDag += 30;
					}
				}
				else
				{
					if ( m % 2 == 1)
					{
						deltaDag += 31;
					}
					else
					{
						deltaDag += 30;
					}
				}
				m--;
			}
			else
			{
				if ( m < 8 )
				{
					if ( m % 2 == 1 )
					{
						deltaDag -= 31;
					}
					else if ( m == 2 )
					{
						if ( y % 4 == 0 )
							deltaDag -= 29;
						else
							deltaDag -= 28;
					}
					else
					{
						deltaDag -= 30;
					}
				}
				else
				{
					if ( m % 2 == 1)
					{
						deltaDag -= 30;
					}
					else
					{
						deltaDag -= 31;
					}
				}
				m++;
			}
		}
		while (d != this.day)
		{
			if (d > this.day)
			{
				deltaDag++;
				d--;
			}
			else
			{
				deltaDag--;
				d++;
			}
		}


		return deltaDag;
	}

	//uofficiel ugeberegning
	public int beregnUge() {
		return ( ( new Dato(1, 1, this.year).getDeltaDag(this)) / 7 ) + 1;
	}

	public int getDay() {
		return this.day;
	}

	public int getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}

	public String getFormatedDate () {
		return "" + this.day + "-" + this.month + "-" + this.year;
	}

}

//PABLO GARCIA CELADILLA

package es.unileon.prg1.date;




public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date(){
		this.day=1;
		this.month=1;
		this.year=2017;
	}
	
	public Date(int day, int month, int year) throws DateException{
		StringBuffer message=new StringBuffer();
		
		if(day <= 0){
			message.append("Wrong value for day:" +day+ "\n");
		}
		if(month <= 0){
			message.append("Wrong value for month:" +month+ "\n");
		}else{
			if(month > 12){
				message.append("There are only 12 months-Wrong value for month:" +month+ "\n");
			}else{
				if(day > this.daysOfMonth(month)){
					message.append("Day and month are wrong combination:" +day+"/"+month+ "\n");
				}
			}
		}
		if(year < 0){
			message.append("Wrong value for year:" +year+ "\n");
		}
		if(message.length() != 0){
			throw new DateException(message.toString());
		}else{
			this.day=day;
			this.month=month;
			this.year=year;
		}
	}
	
//clone contructor
	
	public Date(Date another){
		this.day = another.getDay();
		this.month = another.getMonth();
		this.year = another.getYear();
	}
	

	public int getDay(){
		return this.day;
	}
	
	public void setDay(int day) throws DateException{
		if(day <= 0){
			throw new DateException("Wrong value for day:" + day + "\n");
		}else{
			if( !this.isDayRight()){
				throw new DateException("Day and month are wrong combination" +day+ "/" + this.month + "\n");
			}else{
				this.day = day;
			}
		}
	}

	public int getMonth(){
		return this.month;
	}
	
	public void setMonth(int month) throws DateException{
		if(month <= 0){
			throw new DateException("Wrong value for month:" + month + "\n");
		}else{
			if(month > 12){
				throw new DateException("There are onley 12 month-Wrong value for month" +month+ "\n");
			}else{
				this.month = month;
			}
		}
	}

	public int getYear(){
		return this.year;
	}

	public void setYear(int year) throws DateException{
		if(year <= 0){
			throw new DateException("Wrong value for year:" + year + "\n");
		}else{
			this.year = year;
			
		}
	}
	
	public Date tomorrow(){
		Date tomorrow=null;
		int d,m,y;
		
		d=this.day;
		m=this.month;
		y=this.year;
		
		d++;
		if(d>this.daysOfMonth(month)){
			d=1;
			m++;
			if(m>12){
				m=1;
				y++;
			}
		}
		try{
			tomorrow=new Date(d,m,y);
		}catch(DateException e){
			System.out.println("Date.tomorrow:" + e.getMessage());
		}
		
		return tomorrow;
	}
//SAME YEAR
	boolean isSameYear(Date other){
		return this.year == other.getYear();
			
	}

//SAME MONTH
	boolean isSameMonth(Date other){
		if ( this.month == other.getMonth()){
			return true;
		}else{
			return false;
		}
	}
		

//SAME DAY
	boolean isSameDay(Date other){
		if ( this.day == other.getDay()){
			return true;
		}else{
			return false;
		}
	}

//SAME DATE
	boolean isSame(Date other){
		return this.year == other.getYear();
	}
	
//SIN IF
public boolean isSameYearWithOutIf(int year){
	return (this.year == year);
}

public boolean isSameMonthWithOutIf(int month){
	return (this.month == month);
}

public boolean isSameDayWithOutIf(int day){
	return (this.day == day);
}

public boolean isSameWithOutIf(Date unaFecha){
	return (day == unaFecha.day && month == unaFecha.month && year == unaFecha.year);
}

	
//IMPRIME EL NOMBRE DEL MES
	public String getMonthName(){
		String name= null;

		switch(this.month){
			case 1: name="January";
				break;
			case 2: name="Fabruary";
				break;
			case 3: name="March";
				break;
			case 4: name="April";
				break;
			case 5: name="May";
				break;
			case 6: name="June";
				break;
			case 7: name="July";
				break;
			case 8: name="August";
				break;
			case 9: name="September";
				break;
			case 10: name="October";
				break;
			case 11: name="Nobember";
				break;
			case 12: name="December";
				break;
		}
	return name;
	}
	
	private boolean isDayRight(){
		return ((day > 0) && (day <=this.daysOfMonth(this.month)));
	}
	
	public int daysOfMonth(){
		return this.daysOfMonth(this.month);
	}
//VERIFICA SI ELDIA DELMES ES CORRECTO
	private int daysOfMonth(int month){
		int number = 0;
		switch(month){
			case 1: //next
			case 3: //next
			case 5: //next
			case 7: //next
			case 8: //next
			case 10: //next
			case 12: 
				number=31;
				break;
			case 4: //next
			case 6: //next
			case 9: //next
			case 11:
				number = 30;
				break;
			case 2:
				number = 28;
				break;
			default:
				number = -1;
		
				
		}
		return number;
	}

//IMPRIME LA ESTACION DE ESTE MES
	public String getSeasonName(){
		String season=null;

		switch(this.month){
		case 1: //next
		case 2: //next
		case 3: 
			if (day<=21){
				season="Winter";
			}
			else{
				season="Spring";
			}
			break;
		case 4: //next
		case 5: //next
		case 6: 
			if (day<=21){
				season="Spring";
			}
			else{
				season="Summer";
			}
			break;
		case 7: //next
		case 8: //next
		case 9: 
			if (day<=23){
				season="Summer";
			}
			else{
				season="Autumn";
			}
			break;
		case 10: //next
		case 11: //next
		case 12:
			if (day<=21){
				season="Autumn";
			}
			else{
				season="Winter";
			}
			break;
		}
return season;
}


//IMPRIME LOS MESES QUE FALTAN HASTA FINAL DE ANIO
	public String getMonthsLeft(){
		Date aux = new Date(this);
		StringBuffer monthsLeft = new StringBuffer();
		
		try{
			for(int i = this.month +1;i<=12;i++){
				aux.setMonth(i);
				monthsLeft.append(aux.getMonthName()+ " ");
			}
		}catch(DateException e){
			System.out.println("Date.getMonthsLeft:" +e.getMessage());
		}
		return monthsLeft.toString();
	}

	public String getDaysLeftOfMonth(){
		Date aux = tomorrow();
		StringBuffer daysLeft = new StringBuffer();
		
		try{
			for(int i = this.getDay(); isDayRight();i++){
				aux.setDay(i);
				daysLeft.append(aux.toString()+ " ");
			}
		}catch(DateException e){
			System.err.println("Date.getDaysLeftOfMonth:" +e.getMessage());
		}
		return daysLeft.toString();
	}
	
	public String getMonthsSameDays(){
		Date aux = new Date(this);
		StringBuffer months = new StringBuffer();
		
		try{
			for(int i = 1;i<=12;i++){
				aux.setMonth(i);
				if(aux.daysOfMonth() == this.daysOfMonth()){
					months.append(aux.getMonthName()+ " ");
				}
			}
		}catch(DateException e){
			System.err.println("Date.getMonthsSameDays:" +e.getMessage());
		}
		return months.toString();
	}
	
	public int daysPast(){
		int result;
		result = 0;
		
		try{
			Date aux=new Date(1,1,this.year);
			for(int i=1;i<this.month; i++){
				result += aux.daysOfMonth();
				aux.setMonth(i+1);
			}
		}catch(DateException e){
			System.out.println("Date.daysPast:" +e.getMessage());
		}
		return result + this.day -1;
	}
//IMPRIMEUNA FECHA
	public void imprimirFecha(Date fecha){
		String mesString=pasarMesString(fecha.month);
		System.out.println(fecha.day+" de " +mesString+" de "+fecha.year);
	}

	private String pasarMesString(int month2) {

		return null;
}

//DIAS DESDE EL PRIMER DEL ANIO
	public int diasTranscurridosAnio(int Date ){
		int diasTotales = 0;

		switch(Date){

			case 1:diasTotales=0;
				break;
			case 2:diasTotales=31;
				break;
			case 3:diasTotales=59;
				break;
			case 4:diasTotales=90;
				break;
			case 5:diasTotales=120;
				break;
			case 6:diasTotales=151;
				break;
			case 7:diasTotales=181;
				break;
			case 8:diasTotales=212;
				break;
			case 9:diasTotales=243;
				break;
			case 10:diasTotales=273;
				break;
			case 11:diasTotales=304;
				break;
			case 12:diasTotales=334;
				break;
		
		
		}
		diasTotales=Date+this.day;
		
		return diasTotales;
	}
//INTENTO PARA GENERAR FECHA ALEATORIA IGUAL A FECHA while
	public int numRandomTriesEqualDate() {
		
		int tries,d,m,y;
		tries=0;
		
		try{
			do{
				m=(int)(Math.random()*12)+1;
				d=(int)(Math.random()*30)+1;
				y=this.year;
				
				tries++;

			}while(!this.isSame(new Date(d,m,y)));
			}catch(DateException e){
				System.err.println("Date.numRandomTriesEqualsDate:" + e.getMessage());
			}
			
	return tries;
		
	}
			
			

	


//DIA DE LA SEMANA
	public String dayOfWeek() {
		String dayName = "";
	
		switch (day) {
		case 1: 
			dayName = "Monday";
			break;
		case 2: 
			dayName = "Tuesday";
			break;
		case 3: 
			dayName = "Wednesday";
			break;
		case 4: 
			dayName = "Thursday";
			break;
		case 5: 
			dayName = "Friday";
			break;
		case 6: 
			dayName = "Saturday";
			break;
		case 7: 
			dayName = "Sunday";
			break;
		default:
			dayName = "Wrong day";
		}
	
		return dayName;
	}

public String toString(){
		
		return this.day + "/" + this.month + "/" + this.year;
	}

	
}

//PABLO GARCIA CELADILLA

package es.unileon.prg1.date;


public class Date {

	private int day;
	private int month;
	private int year;
	
	
	
	public Date(int day, int month, int year){

		this.day = day;
		this.month = month;
		this.year = year;
	}
	

	public int getYear(){
		return this.year;
	}


	public int getMonth(){
		return this.month;
	}
	

	public int getDay(){
		return this.day;
	}

//SAME YEAR
	boolean isSameYear(int oneYear){
		if ( this.year == oneYear ){
			return true;
		}
		return false;
	}

//SAME MONTH
	boolean isSameMonth(int oneMonth){
		if ( this.month == oneMonth){
			return true;
		}
		return false;
	}

//SAME DAY
	boolean isSameDay(int oneDay){
		if ( this.day == oneDay){
			return true;
		}
		return false;
	}

//SAME DATE
	boolean isSame(Date unaFecha){
		if(day==unaFecha.day && month==unaFecha.month && year==unaFecha.year){
			return true;
		}
		return false;
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
	public String getMonthName(int month){
		String mes= "";

		switch(this.month){
			case 1: mes="ENERO";
				break;
			case 2: mes="FEBRERO";
				break;
			case 3: mes="MARZO";
				break;
			case 4: mes="ABRIL";
				break;
			case 5: mes="MAYO";
				break;
			case 6: mes="JUNIO";
				break;
			case 7: mes="JULIO";
				break;
			case 8: mes="AGOSTO";
				break;
			case 9: mes="SEPTIEMBRE";
				break;
			case 10: mes="OCTUBRE";
				break;
			case 11: mes="NOVIEMBRE";
				break;
			case 12: mes="DICIEMBRE";
				break;
		}
	return mes;
	}
	
//VERIFICA SI ELDIA DELMES ES CORRECTO
	public boolean fechaCorrecta(int day,int month,int year){

		if(day<=0 || day>31 || year<0 || month<=0 ||month>12){
			return false;
		}
		if((day<=31 && (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12))){
			return true;
		}
		else if((day<=30) && (month==4 || month==6 || month==9 || month==11)){
			return true;
		}
		else if(day<29 && month==2){
			return true;
		}
		else{
			return false;
		}
	}

//IMPRIME LA ESTACION DE ESTE MES
	public String seasonMonth(int month,int day){
		String season="";

		switch(month){
			case 1: season="Estacion: INVIERNO";
				break;
			case 2: season="Estacion: INVIERNO";
				break;
			case 3: 
				if (this.day<=21){
					season="Estacion: INVIERNO";
				}
				else{
					season="Estacion: PRIMAVERA";
				}
				break;
			case 4: season="Estacion: PRIMAVERA";
				break;
			case 5: season="Estacion: PRIMAVERA";
				break;
			case 6: 
				if (this.day<=21){
					season="Estacion: PRIMAVERA";
				}
				else{
					season="Estacion: VERANO";
				}
				break;
			case 7: season="Estacion: VERANO";
				break;
			case 8: season="Estacion: VERANO";
				break;
			case 9: if (this.day<=21){
					season="Estacion: VERANO";
				}
				else{
					season="Estacion: OTOÑO";
				}
				break;
			case 10: season="Estacion: OTOÑO";
				break;
			case 11: season="Estacion: OTOÑO";
				break;
			case 12:if (this.day<=21){
					season="Estacion: OTOÑO";
				}
				else{
					season="Estacion: INVIERNO";
				}
				break;
			}
	return season;
	}

//IMPRIME LOS MESES QUE FALTAN HASTA FINAL DE AÑO
	public int mesesHastaFinalDeAo(int month){
		int i,j=0;
			for(i=month; i<=12; i++){
				j++;
			}
	return j;
	}

//IMPRIMEUNA FECHA
	public void imprimirFecha(Date fecha){
		String mesString=pasarMesString(fecha.month);
		System.out.println(fecha.day+" de " +mesString+" de "+fecha.year);
	}

	private String pasarMesString(int month2) {

		return null;
}

//DIAS DESDE EL PRIMER DEL AÑO
	public int diasTranscurridosAño(int Date ){
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
	public int intentosAcertarFechaWhile() {
		
		int intentos=0;
		
		boolean caso=false;
		
		int d,m;
		
		while(caso==false){
			
			m=(int)(Math.random()*12)+1;
			
			if(m==4 || m==6 || m==9 || m==11){
				d=(int)(Math.random()*30)+1;

			}
			else if(m==2){
				d=(int)(Math.random()*28)+1;
			}
			else{
				d=(int)(Math.random()*31)+1;
			}
				intentos++;
				
			if(m==this.month && d==this.day){
				caso=true;
			}
			
		}
			
			return intentos;
	}

	


//DIA DE LA SEMANA
	public String diaSemana(int day, int month){
		
		int a=0,num=0;
		String _dia="";

		for(int i=1;i<=num;i++){
			a++;
		}
		switch(a) {
			
			case 1:  _dia="LUNES";
				break;
			case 2: _dia="MARTES";
				break;
			case 3:  _dia="MIERCOLES";
				break;
			case 4:  _dia="JUEVES";
				break;
			case 5:  _dia="VIERNES";
				break;
			case 6: _dia="SABADO";
				break;
			case 7:  _dia="DOMINGO";
				break;
		}		

	return _dia;
	}
}



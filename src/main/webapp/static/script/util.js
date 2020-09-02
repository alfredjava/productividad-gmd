function ingresarSoloNumeros(e)
{
var key=(document.all) ? e.keyCode : e.which;

if (key < 48 || key > 57 )
{
	if (key==8)
	{
		return true;
	}else
		if(e.preventDefault) e.preventDefault();
		e.returnValue = false;
		return false;
	}
}
function conMayusculas(field) {	
    field.value = field.value.toUpperCase();
}
function validarSoloLetras(e) { // 1
	/*
	 *  //225 á
    	//233 é
    	//237 í
    	//243 ó
    	//250 ú
    	//193 Á
    	//201 É
    	//205 Í
    	//211 Ó
    	//218 Ú
	 */
    tecla = (document.all) ? e.keyCode : e.which; // 2
    var tildes=["225","233","237","243","250","193","201","205","211","218"];  
    volcal_tilde = false;
    for(var i in tildes){
         if(key == tildes[i]){
        	 volcal_tilde = true;
             break;
         }
     }
     if(!volcal_tilde){
    	 if (tecla==8) return true; // 3    
         patron = /^[A-Za-z\s\xF1\xD1]+$/;
         te = String.fromCharCode(tecla); // 5
         return patron.test(te); // 6
     }

}
function ingresarNumSinCeroIni(e,numero)
{	
	 tecla = (document.all) ? e.keyCode : e.which; // 2
     if (tecla==8) return true; // 3    
     patron = /^[0-9]$/;
     te = String.fromCharCode(tecla); // 5
	 /////////////////
	var nunfin=numero.value;	
	var varini=nunfin.substring(0,1);
	if(varini=="0"){	  
	  nunfin=nunfin.substring(1,nunfin.length);
	}
	numero.value=nunfin;
    return patron.test(te); // 6
}
function validarSoloLetraNumero(e) { // 1
    tecla = (document.all) ? e.keyCode : e.which; // 2
	 if (tecla==8) return true; // 3    
	 patron = /^[0-9A-Za-z\s\xF1\xD1]+$/;
	 te = String.fromCharCode(tecla); // 5
	 return patron.test(te); // 6 
}
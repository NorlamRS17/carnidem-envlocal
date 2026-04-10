/*
* Hooks Unificados para validacion de Terceros
*/

//Hook ec.com.sidesoft.customercontrol/web/ec.com.sidesoft.customercontrol/js/hooks/customercontrol.js
//Hook ec.com.sidesoft.pos.sales.zone/web/ec.com.sidesoft.pos.sales.zone/js/posResources/hooks/Extension_CustomerSave.js
//Hook ec.com.sidesoft.carnidem.pos.customizations/web/ec.com.sidesoft.carnidem.pos.customizations/js/posResources/hooks/OBPOS_PreCustomerSave.js
//Hook ec.com.sidesoft.retail.sanfelipe.bpchannel/web/ec.com.sidesoft.retail.sanfelipe.bpchannel/js/bpchannel/hooks/bpchanneledit.js

OB.MobileApp.model.hookManager.registerHook('OBPOS_PreCustomerSave', function (args, c) {
//recoge el valor del campo TaxId nuevo
var cedula 		= args.meObject.$.customerAttributes.$.line_customerTaxId.$.newAttribute.$.customerTaxId.getValue();
//recoge el valor del campo TaxId de base si es que existe
var cedula_old	= args.meObject.$.customerAttributes.$.line_customerTaxId.$.newAttribute.$.customerTaxId.attributes.value;
//recoge el valor del campo TypetaxId
var tipo_id 	= args.meObject.$.customerAttributes.$.line_taxidtypecombo.$.newAttribute.$.taxidtypecombo.$.customerCombo.getValue();
var salesZoneSelected = args.meObject.$.customerAttributes.$.line_customerSalesZone.$.newAttribute.$.customerSalesZone.getValue();

// flag RUC
var flagvalidate=false;

var bpphone = args.meObject.$.customerAttributes.$.line_customerPhone.$.newAttribute.$.customerPhone.getValue();
var bpemail = args.meObject.$.customerAttributes.$.line_customerEmail.$.newAttribute.$.customerEmail.getValue();
var sql='SELECT c_bpartner.taxID FROM c_bpartner WHERE c_bpartner.taxID=?';

if (bpphone.length ==0 || bpemail.length==0){

  var msg ="";
  
  if (bpphone.length ==0){
	msg = "El campo Telefono esta vacio";
  }
  if (bpemail.length ==0){
	msg = "El campo Email esta vacio";
  }
  if (bpemail.length ==0 && bpphone.length ==0){
	msg = "Los campos: Telefono e Email estan vacios";
  }
  OB.UTIL.showConfirmation.display('!! ' + msg);
  args.passValidation=false;
  OB.UTIL.HookManager.callbackExecutor(args, c);

}

//Hook 1
if (salesZoneSelected === "0" || salesZoneSelected == null) {
	args.passValidation = false;
	OB.UTIL.showConfirmation.display('El campo Zona de Venta no puede quedar vac\u00EDo');
	OB.UTIL.HookManager.callbackExecutor(args, c);
} else {
	localStorage.setItem("salesRegion", salesZoneSelected);
}

//Hook 2
var channelid= args.meObject.$.customerAttributes.$.line_bpchannelcombo.$.newAttribute.$.bpchannelcombo.$.customerCombo.getValue();
//args.meObject.$.customerAttributes.$.line_bpchannelcombo.$.newAttribute.$.bpchannelcombo.$.customerCombo.setSelectedValue(channelid,'searchKey');



async function ejecutarValidaciones() {
	    const existe = await validarExistenciaIdentificador(); // hook 3
	    if(existe){
			const valido = await validarIdentificador(); // hook 4
			return valido;
		}else{
			return existe;
		}	    
}

ejecutarValidaciones()
    .then((ok) => {
      if (!ok) {
		console.log(' Validaciones fallidas');
		args.passValidation=false
	  }else{
		console.log(' Validaciones exitosas');
		args.passValidation=true
	  }
      OB.UTIL.HookManager.callbackExecutor(args, c);
    })
    .catch((e) => {
      OB.error('Error en validaciones: ' + e.message);
	  args.passValidation=false;
      OB.UTIL.HookManager.callbackExecutor(args, c);
    });






async function validarExistenciaIdentificador (){
	if(OB.UTIL.isNullOrUndefined(cedula) || cedula.trim() === ''){
            OB.UTIL.showConfirmation.display('!! Campo de identidificador se encuentra vacio ');
            return false;
	}else if (cedula !== cedula_old && OB.Data.localDB) {
	      const exists = await new Promise((resolve, reject) => {
	        OB.Data.localDB.readTransaction(function (tx) {
	          tx.executeSql(sql, [cedula],
	            function (tr, result) {resolve(result.rows.length > 0);},
	            function (tx, error) { reject(error); }
	          );
	        });
	      });

	      if (exists) {
	        OB.UTIL.showConfirmation.display('!! El identificador introducido ya existe');
	        return false;
	      } else {
	        return true;
	      }
	    }else{
			return true;
		}
}


async function validarIdentificador (){

	if( !(OB.UTIL.isNullOrUndefined(tipo_id)) &&  tipo_id != 'D' && tipo_id != 'R' && tipo_id != 'P'){
		//return false;
	}

	if(cedula_old!="" || args.meObject.customer)
	{
		var tipo_id_old	= args.meObject.customer.attributes.sswhTaxidtype;
	}
	// Validacion cambios de  identificador 
	// Si el identificador esta vacio
	if(cedula_old==="" && args.meObject.customer===undefined)
	{
		if(tipo_id==="D")
		{
			return validaCedula(cedula);
		}
		else
		{
			if (tipo_id==="R") 
			{
				flagvalidate = validaRuc22(cedula);
				if (flagvalidate == false){
					OB.UTIL.showConfirmation.display('!! RUC incorrecto');
					return false;
				}else{
					return true;
				}
			}
			else if (tipo_id==="P") 
			{
				return validaPasaporteExiste(cedula);
			}else{
				return true;
			}
			
		}
		//Si el identificador esta vacio
	}
	else
	{
		//Validacion si se cambia el tipo de identificador
		if(tipo_id != tipo_id_old)
		{
			if(tipo_id==="D")
			{
				return validaCedula(cedula);
			}
			else
			{
				if (tipo_id==="R") 
				{
					flagvalidate = validaRuc22(cedula);
					if (flagvalidate == false){
						OB.UTIL.showConfirmation.display('!! RUC incorrecto');
						 return false;
					}else{
						return true;
					}
				}
				else if (tipo_id==="P") 
				{
					return validaPasaporteExiste(cedula);
				}
				else{
                    return true;
                }
			}
		}
		else
		{
			//Validacion si se mantiene el tipo de identificador pero cambia el valor del identificador
			if(cedula_old != cedula)
			{
				if(tipo_id==="D")
				{
					return validaCedula(cedula);
				}
				else
				{
					if (tipo_id==="R") 
					{
						flagvalidate = validaRuc22(cedula);
						if (flagvalidate == false){
							OB.UTIL.showConfirmation.display('!! RUC incorrecto');
							return false;
						}else{
							return true;
						}
					}
					else if (tipo_id==="P") 
					{
						return validaPasaporteExiste(cedula);
					}else{
						return true;
					}		
					
				}
			}
			else
			{
				return true;
			}
		}
	}
}




function validaRuc(cedula){

 if (!/^([0-9])*$/.test(cedula) || cedula.length<13 || cedula.length>13){

     OB.UTIL.showConfirmation.display('!! RUC incorrecto');
	 return false;
      

 }else{

	numero = cedula;
	var suma = 0;
	var residuo = 0;
	var pri = false;
	var pub = false;
	var nat = false;
	var modulo = 11;

	//Aqui almacenamos los digitos de la cedula en variables. 
	d1 = numero.substr(0,1);
	d2 = numero.substr(1,1);
	d3 = numero.substr(2,1);
	d4 = numero.substr(3,1);
	d5 = numero.substr(4,1);
	d6 = numero.substr(5,1);
	d7 = numero.substr(6,1);
	d8 = numero.substr(7,1);
	d9 = numero.substr(8,1);
	d10 = numero.substr(9,1);

	if (d3==7 || d3==8){

 		OB.UTIL.showConfirmation.display('!! RUC incorrecto');
		return false;
	}

	//Solo para personas naturales (modulo 10) 
	if (d3 < 6){
		nat = true;
		p1 = d1 * 2; if (p1 >= 10) p1 -= 9;
		p2 = d2 * 1; if (p2 >= 10) p2 -= 9;
		p3 = d3 * 2; if (p3 >= 10) p3 -= 9;
		p4 = d4 * 1; if (p4 >= 10) p4 -= 9;
		p5 = d5 * 2; if (p5 >= 10) p5 -= 9;
		p6 = d6 * 1; if (p6 >= 10) p6 -= 9;
		p7 = d7 * 2; if (p7 >= 10) p7 -= 9;
		p8 = d8 * 1; if (p8 >= 10) p8 -= 9;
		p9 = d9 * 2; if (p9 >= 10) p9 -= 9;
		modulo = 10;

	}else if(d3 == 6){
		pub = true;
		p1 = d1 * 3;
		p2 = d2 * 2;
		p3 = d3 * 7;
		p4 = d4 * 6;
		p5 = d5 * 5;
		p6 = d6 * 4;
		p7 = d7 * 3;
		p8 = d8 * 2;
		p9 = 0;

	}else if(d3 == 9) { //Solo para entidades privadas (modulo 11) 
		pri = true;
		p1 = d1 * 4;
		p2 = d2 * 3;
		p3 = d3 * 2;
		p4 = d4 * 7;
		p5 = d5 * 6;
		p6 = d6 * 5;
		p7 = d7 * 4;
		p8 = d8 * 3;
		p9 = d9 * 2;
	}

	suma = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9;
	residuo = suma % modulo;

	//Si residuo=0, dig.ver.=0, caso contrario modulo - residuo
	digitoVerificador = residuo==0 ? 0: modulo - residuo;
	if (modulo === 11 && digitoVerificador === 10) {
		digitoVerificador = 0;
	}

	//ahora comparamos el elemento de la posicion 10 con el dig. ver.
	if (pub==true){
		if (digitoVerificador !== parseInt(d9, 10)){
		 	OB.UTIL.showConfirmation.display('!! RUC incorrecto');
			return false;
		}
		// El ruc de las empresas del sector publico terminan con 0001
		if ( numero.substr(9,4) != '0001' ){
	 		OB.UTIL.showConfirmation.display('!! RUC incorrecto');
			return false;
		}

	}else if(pri == true){
		var dvIngresadoPri = parseInt(d10, 10);
		if (digitoVerificador !== dvIngresadoPri) {
			var remPri = suma % 11;
			var dvRestoDirecto = (remPri === 10) ? 0 : remPri;
			if (dvRestoDirecto !== dvIngresadoPri) {
		 	OB.UTIL.showConfirmation.display('!! RUC incorrecto');
			return false;
			}
		}
		if ( numero.substr(10,3) != '001' ){
		 	OB.UTIL.showConfirmation.display('!! RUC incorrecto');
			return false;
		}

	}else if(nat == true){
		if (digitoVerificador !== parseInt(d10, 10)){
			OB.UTIL.showConfirmation.display('!! RUC incorrecto');
			return false;
		}
		if (numero.length >13 && numero.substr(10,3) != '001' ){
		 	OB.UTIL.showConfirmation.display('!! RUC incorrecto');
			return false;
		}
	}

	return true;

 	}
};

function validaCedula(cedula){
	//Algoritmo de validacion de cedula  
	array = cedula.split( "" );
  	num = array.length;
  	if(cedula == "0000000000"){
		OB.UTIL.showConfirmation.display('!! Identificador incorrecto');
		return false;	

  	}else if ( num == 10 ){
	    total = 0;
	    digito = (array[9]*1);
    	for( i=0; i < (num-1); i++ ){
      		mult = 0;
      		if ( ( i%2 ) != 0 ) {

        		total = total + ( array[i] * 1 );
      		}else{
        		mult = array[i] * 2;
        		if ( mult > 9 ){

          			total = total + ( mult - 9 );

        		}else{

		          	total = total + mult;	
        		}
      		}
    	}
    	decena = total / 10;
    	decena = Math.floor( decena );
    	decena = ( decena + 1 ) * 10;
    	final = ( decena - total );
    	if ( ( final == 10 && digito == 0 ) || ( final == digito ) ) 
		{
			return true;
    	}
		else
		{
			OB.UTIL.showConfirmation.display('!! Identificador incorrecto');
     		return false;
     		
		}
  	}
	else //Validacion 10 digitos
	{
		OB.UTIL.showConfirmation.display('!! Identificador incorrecto');
		return false;
  	}
};

function validaPasaporteExiste(cedula){
	//Algoritmo de validacion de pasaporte  
	array = cedula.split( "" );
  	num = array.length;

  	if(cedula == "0000000000"){

		OB.UTIL.showConfirmation.display('!! Identificador incorrecto');
		return false;

  	}else {
		return true;
  	}
};
	
	
	
function validaRuc22(cedula){

		 if (!/^([0-9])*$/.test(cedula) || cedula.length<13 || cedula.length>13){

			 return false;
		      

		 }else{

			numero = cedula;
			var suma = 0;
			var residuo = 0;
			var pri = false;
			var pub = false;
			var nat = false;
			var modulo = 11;

			//Aqui almacenamos los digitos de la cedula en variables. 
			d1 = numero.substr(0,1);
			d2 = numero.substr(1,1);
			d3 = numero.substr(2,1);
			d4 = numero.substr(3,1);
			d5 = numero.substr(4,1);
			d6 = numero.substr(5,1);
			d7 = numero.substr(6,1);
			d8 = numero.substr(7,1);
			d9 = numero.substr(8,1);
			d10 = numero.substr(9,1);

			if (d3==7 || d3==8){

				return false;
			}

			//Solo para personas naturales (modulo 10) 
			if (d3 < 6){
				nat = true;
				p1 = d1 * 2; if (p1 >= 10) p1 -= 9;
				p2 = d2 * 1; if (p2 >= 10) p2 -= 9;
				p3 = d3 * 2; if (p3 >= 10) p3 -= 9;
				p4 = d4 * 1; if (p4 >= 10) p4 -= 9;
				p5 = d5 * 2; if (p5 >= 10) p5 -= 9;
				p6 = d6 * 1; if (p6 >= 10) p6 -= 9;
				p7 = d7 * 2; if (p7 >= 10) p7 -= 9;
				p8 = d8 * 1; if (p8 >= 10) p8 -= 9;
				p9 = d9 * 2; if (p9 >= 10) p9 -= 9;
				modulo = 10;

			}else if(d3 == 6){
				pub = true;
				p1 = d1 * 3;
				p2 = d2 * 2;
				p3 = d3 * 7;
				p4 = d4 * 6;
				p5 = d5 * 5;
				p6 = d6 * 4;
				p7 = d7 * 3;
				p8 = d8 * 2;
				p9 = 0;

			}else if(d3 == 9) { //Solo para entidades privadas (modulo 11) 
				pri = true;
				p1 = d1 * 4;
				p2 = d2 * 3;
				p3 = d3 * 2;
				p4 = d4 * 7;
				p5 = d5 * 6;
				p6 = d6 * 5;
				p7 = d7 * 4;
				p8 = d8 * 3;
				p9 = d9 * 2;
			}

			suma = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9;
			residuo = suma % modulo;

			//Si residuo=0, dig.ver.=0, caso contrario modulo - residuo
			digitoVerificador = residuo==0 ? 0: modulo - residuo;
			// Módulo 11 (SRI): si el resultado es 10, el dígito verificador registrado es 0
			if (modulo === 11 && digitoVerificador === 10) {
				digitoVerificador = 0;
			}

			//ahora comparamos el elemento de la posicion 10 con el dig. ver.
			if (pub==true){
				if (digitoVerificador !== parseInt(d9, 10)){

					return false;
				}
				// El ruc de las empresas del sector publico terminan con 0001
				if ( numero.substr(9,4) != '0001' ){
					return false;
				}

			}else if(pri == true){
				var dvIngresadoPri = parseInt(d10, 10);
				if (digitoVerificador !== dvIngresadoPri) {
					var remPri = suma % 11;
					var dvRestoDirecto = (remPri === 10) ? 0 : remPri;
					if (dvRestoDirecto !== dvIngresadoPri) {
						return false;
					}
				}
				if ( numero.substr(10,3) != '001' ){
					return false;
				}

			}else if(nat == true){

				if (digitoVerificador !== parseInt(d10, 10)){
					return false;
				}
				if (numero.substr(10,3) != '001' ){
					return false;
				}
			}
			
			return true;

		 	}
		};

});

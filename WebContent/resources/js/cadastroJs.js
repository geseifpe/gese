//onload = function inicio () {    
//	
//  document.getElementById("submit").onclick = submeter;
//  document.getElementById("nome").onkeyup = maiusculo; 
//  document.getElementById("cpf").onkeypress = validar;
//  document.getElementById("tel").onkeypress = validar;
//  document.getElementById("cel").onkeypress = validar;
//};
//function maiusculo() {
//    var x = document.getElementById("nome");
//    x.value = x.value.toUpperCase();
//}
//function validar(ev){         
//    var tecla = ev.keyCode;        
//    if((tecla>47 && tecla<58)) {
//        //formatar("###.###.###-##", this);
//        return true;     
//    }
//    else  return false;
//    
//}
//function formatar(mascara, documento){ 
//  var i = documento.value.length;   
//  var saida = mascara.substring(0,1);
//  var texto = mascara.substring(i);  
//  if(texto.substring(0,1) !== saida)  
//    documento.value += texto.substring(0,1);
//  	
//}
//
//
//function submeter() {   	               
//    
//	if(document.getElementById("email").value !== document.getElementById("emailConfirmacao").value) {
//        alert("Emails nao conferem");        
//    }
//    else if(document.getElementById("senha").value !== document.getElementById("senhaConfirmacao").value) {         
//        alert("Senhas nao conferem");        
//    }    
//    
//}

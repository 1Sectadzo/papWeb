/**
 * 
 */
 
 function confirmarr(id){
    //alert(id)
    let resposta = confirm("Confirma a exclusão deste projeto?")
    if(resposta===true){
        //alert(id)
        window.location.href="deleteProj?id="+id
    }
   
}
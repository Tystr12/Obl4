/**
 * New class to implement changes in the log in page.
 * 
 */
 
 function checkIfNumberIsValid() {
    
    let mobil = document.getElementById("mobil");
    if(mobil.length !== 8) {
        alert("Mobilnummer må ha 8 tall. Prøv igjen");
    }
       
 }
 
 checkIfNumberIsValid();
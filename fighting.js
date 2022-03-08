document.getElementById("health1").innerHTML = 100;
document.getElementById("mana1").innerHTML = 30;
document.getElementById("health2").innerHTML = 65;
document.getElementById("mana2").innerHTML = 75;
var cat = 0;

function basicAttack() {
    var curhp = Number(document.getElementById("health2").innerHTML);
    if ((curhp - 10) < 0) {
        document.getElementById("health2").innerHTML = 0;
        on();
    } else {
        document.getElementById("health2").innerHTML -= 10;
    }
    var redPer = (document.getElementById("health2").innerHTML / 65) * 100;
    var whitePer = 100 - redPer;
    console.log(redPer);
    document.getElementById('hp2').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
    document.getElementById("fighter2").classList.add('shake');
    setTimeout(function () { document.getElementById("fighter2").classList.remove('shake') }, 500);
}

function abl1() {
    var curhp = Number(document.getElementById("health2").innerHTML);
    var curmana = Number(document.getElementById("mana1").innerHTML);
    if (curmana >= 12) {
        if ((curhp - 15) < 0) {
            document.getElementById("health2").innerHTML = 0;
            document.getElementById("mana1").innerHTML -= 12;
            on();
        } else {
            document.getElementById("health2").innerHTML -= 15;
            document.getElementById("mana1").innerHTML -= 12;
        }
        var redPer = (document.getElementById("health2").innerHTML / 65) * 100;
        var bluePar = (document.getElementById("mana1").innerHTML / 30) * 100;
        var whitePer = 100 - redPer;
        console.log(redPer);
        console.log(bluePar);
        document.getElementById('hp2').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
        whitePer = 100 - bluePar;
        document.getElementById('mp1').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
        document.getElementById("fighter2").classList.add('shake');
        setTimeout(function () { document.getElementById("fighter2").classList.remove('shake') }, 500);
    }
}

function abl2() {
    var curhp = Number(document.getElementById("health2").innerHTML);
    var curmana = Number(document.getElementById("mana1").innerHTML);
    if (curmana >= 6) {
        if ((curhp - 12) < 0) {
            document.getElementById("health2").innerHTML = 0;
            document.getElementById("mana1").innerHTML -= 6;
            on();
        } else {
            document.getElementById("health2").innerHTML -= 12;
            document.getElementById("mana1").innerHTML -= 6;
        }
        var redPer = (document.getElementById("health2").innerHTML / 65) * 100;
        var bluePar = (document.getElementById("mana1").innerHTML / 30) * 100;
        var whitePer = 100 - redPer;
        console.log(redPer);
        console.log(whitePer);
        document.getElementById('hp2').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
        whitePer = 100 - bluePar;
        document.getElementById('mp1').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
        document.getElementById("fighter2").classList.add('shake');
        setTimeout(function () { document.getElementById("fighter2").classList.remove('shake') }, 500);
    }
}

function abl3() {
    var curhp = Number(document.getElementById("health1").innerHTML);
    var curmana = Number(document.getElementById("mana1").innerHTML);
    if (cat == 0) {
        if ((curhp + 50) > 100) {
            document.getElementById("health1").innerHTML = 100;
        } else {
            document.getElementById("health1").innerHTML += 50;
        }
        if ((curmana + 15) > 30) {
            document.getElementById("mana1").innerHTML = 30;
        } else {
            document.getElementById("mana1").innerHTML = Number(document.getElementById("mana1").innerHTML) + 15;
        }
        cat += 1;
        var redPer = (document.getElementById("health1").innerHTML / 65) * 100;
        var bluePar = (document.getElementById("mana1").innerHTML / 30) * 100;
        var whitePer = 100 - redPer;
        console.log(redPer);
        console.log(whitePer);
        document.getElementById('hp1').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
        whitePer = 100 - bluePar;
        document.getElementById('mp1').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
        document.getElementById("fighter1").classList.add('shake');
        setTimeout(function () { document.getElementById("fighter1").classList.remove('shake') }, 500);
    }
}

function on() {
    document.getElementById("overlay").style.display = "flex";
}

function off() {
    document.getElementById("overlay").style.display = "none";
}

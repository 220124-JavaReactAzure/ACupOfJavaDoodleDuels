a = JSON.parse((localStorage.getItem("current_user")));
console.log(a.username);
var dueler1
var curUser = {
    username: a.username
}

var fighter1Strength;
var fighter1Dexterity;
var fighter1Constitution;
var fighter1Wisdom;
var fighter1Intelligence;
var fighter1Charisma;
var abl1healing;
var abl1Damage;
var abl1Stat;
var abl1Scaling;
var abl1ScalingReq;
var abl1ManaCost;
var abl2healing;
var abl2Damage;
var abl2Stat;
var abl2Scaling;
var abl2ScalingReq;
var abl2ManaCost;
var abl3healing;
var abl3Damage;
var abl3Stat;
var abl3Scaling;
var abl3ScalingReq;
var abl3ManaCost;

fetch("https://java-doodle-duels.azurewebsites.net/fighter1", {
    method: 'POST',
    credentials: 'include',
    origin: true,
    headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify(curUser)
})
    .then(response => {
        return response.json();
    }).then(data => {
        dueler1 = data;
        console.log(dueler1);
    }).then(function fillInfo() {
        //fighter 1 core elements
        document.getElementById("maxHealth1").innerHTML = dueler1.dueler.maxHealth;
        document.getElementById("health1").innerHTML = dueler1.dueler.maxHealth;
        document.getElementById("maxMana1").innerHTML = dueler1.dueler.maxMana;
        document.getElementById("mana1").innerHTML = dueler1.dueler.maxMana;
        document.getElementById("fighter1").src = dueler1.dueler.duelerImage;
        document.getElementById("fighterName1").innerHTML = dueler1.dueler.duelerName;

        //fighter 1 stats
        fighter1Strength = dueler1.dueler.strength;
        fighter1Dexterity = dueler1.dueler.dexterity;
        fighter1Constitution = dueler1.dueler.constitution;
        fighter1Wisdom = dueler1.dueler.wisdom;
        fighter1Intelligence = dueler1.dueler.intelligence;
        fighter1Charisma = dueler1.dueler.charisma;

        //fighter 1 basic attack
        document.getElementById("basicDesc").innerHTML = "Deal " + Math.floor(fighter1Strength / 2) + " physical damage";

        //fighter 1 skill 1
        document.getElementById("skill1").innerHTML = dueler1.skillOne.skillName;
        document.getElementById("abl1Desc").innerHTML = dueler1.skillOne.description;
        abl1healing = dueler1.skillOne.healing;
        abl1Damage = dueler1.skillOne.damage;
        abl1Stat = dueler1.skillOne.damageStatType;
        abl1Scaling = dueler1.skillOne.scaledDamage;
        abl1ScalingReq = dueler1.skillOne.scalingRequirement;
        abl1ManaCost = dueler1.skillOne.manaCost;
        if (abl1Stat == "strength") {
            abl1Damage = Number(abl1Damage) + ((fighter1Strength - abl1ScalingReq) * abl1Scaling);
        }
        else if (abl1Stat == "dexterity") {
            abl1Damage = Number(abl1Damage) + ((fighter1Dexterity - abl1ScalingReq) * abl1Scaling);
        }
        else if (abl1Stat == "constitution") {
            abl1Damage = Number(abl1Damage) + ((fighter1Constitution - abl1ScalingReq) * abl1Scaling);
        }
        else if (abl1Stat == "wisdom") {
            abl1Damage = Number(abl1Damage) + ((fighter1Wisdom - abl1ScalingReq) * abl1Scaling);
        }
        else if (abl1Stat == "intelligence") {
            abl1Damage = Number(abl1Damage) + ((fighter1Intelligence - abl1ScalingReq) * abl1Scaling);
        }
        else if (abl1Stat == "charisma") {
            abl1Damage = Number(abl1Damage) + ((fighter1Charisma - abl1ScalingReq) * abl1Scaling);
        }

        //fighter 1 skill 2
        document.getElementById("skill2").innerHTML = dueler1.skillTwo.skillName;
        document.getElementById("abl2Desc").innerHTML = dueler1.skillTwo.description;
        abl2healing = dueler1.skillTwo.healing;
        abl2Damage = dueler1.skillTwo.damage;
        abl2Stat = dueler1.skillTwo.damageStatType;
        abl2Scaling = dueler1.skillTwo.scaledDamage;
        abl2ScalingReq = dueler1.skillTwo.scalingRequirement;
        abl2ManaCost = dueler1.skillTwo.manaCost;
        if (abl2Stat == "strength") {
            abl2Damage = Number(abl2Damage) + ((fighter1Strength - abl2ScalingReq) * abl2Scaling);
        }
        else if (abl2Stat == "dexterity") {
            abl2Damage = Number(abl2Damage) + ((fighter1Dexterity - abl2ScalingReq) * abl2Scaling);
        }
        else if (abl2Stat == "constitution") {
            abl2Damage = Number(abl2Damage) + ((fighter1Constitution - abl2ScalingReq) * abl2Scaling);
        }
        else if (abl2Stat == "wisdom") {
            abl2Damage = Number(abl2Damage) + ((fighter1Wisdom - abl2ScalingReq) * abl2Scaling);
        }
        else if (abl2Stat == "intelligence") {
            abl2Damage = Number(abl2Damage) + ((fighter1Intelligence - abl2ScalingReq) * abl2Scaling);
        }
        else if (abl2Stat == "charisma") {
            abl2Damage = Number(abl2Damage) + ((fighter1Charisma - abl2ScalingReq) * abl2Scaling);
        }

        //fighter 1 skill 3
        document.getElementById("skill3").innerHTML = dueler1.skillThree.skillName;
        document.getElementById("abl3Desc").innerHTML = dueler1.skillThree.description;
        abl3healing = dueler1.skillThree.healing;
        abl3Damage = dueler1.skillThree.damage;
        abl3Stat = dueler1.skillThree.damageStatType;
        abl3Scaling = dueler1.skillThree.scaledDamage;
        abl3ScalingReq = dueler1.skillThree.scalingRequirement;
        abl3ManaCost = dueler1.skillThree.manaCost;
        if (abl3Stat == "strength") {
            abl3Damage = Number(abl3Damage) + ((fighter1Strength - abl3ScalingReq) * abl3Scaling);
        }
        else if (abl3Stat == "dexterity") {
            abl3Damage = Number(abl3Damage) + ((fighter1Dexterity - abl3ScalingReq) * abl3Scaling);
        }
        else if (abl3Stat == "constitution") {
            abl3Damage = Number(abl3Damage) + ((fighter1Constitution - abl3ScalingReq) * abl3Scaling);
        }
        else if (abl3Stat == "wisdom") {
            abl3Damage = Number(abl3Damage) + ((fighter1Wisdom - abl3ScalingReq) * abl3Scaling);
        }
        else if (abl3Stat == "intelligence") {
            abl3Damage = Number(abl3Damage) + ((fighter1Intelligence - abl3ScalingReq) * abl3Scaling);
        }
        else if (abl3Stat == "charisma") {
            abl3Damage = Number(abl3Damage) + ((fighter1Charisma - abl3ScalingReq) * abl3Scaling);
        }

    });


//fighter 2 core elements
document.getElementById("maxHealth2").innerHTML = 65;
document.getElementById("health2").innerHTML = 65;
document.getElementById("maxMana2").innerHTML = 75;
document.getElementById("mana2").innerHTML = 75;

document.getElementById("fighter2").src = "https://cdn.discordapp.com/attachments/946784294473453628/948677957025677372/unknown.png";
document.getElementById("fighterName2").innerHTML = "Gordon The Turtle"


//fighter 2 stats
var fighter2Strength = 17;
var fighter2Dexterity = 18;
var fighter2Constitution = 18;
var fighter2Wisdom = 18;
var fighter2Intelligence = 18;
var fighter2Charisma = 18;

//fighter 2 basic attack
//document.getElementById("basicDesc").innerHTML = "Deal " + Math.floor(fighter2Strength/2) + " physical damage";

//fighter 2 skill 1
var fighter2abl1healing = 0;
var fighter2abl1Damage = 6;
var fighter2abl1Stat = "intelligence";
var fighter2abl1Scaling = 1;
var fighter2abl1ScalingReq = 12;
var fighter2abl1ManaCost = 10;
if (fighter2abl1Stat == "strength") {

    fighter2abl1Damage = Number(fighter2abl1Damage) + ((fighter2Strength - fighter2abl1ScalingReq) * fighter2abl1Scaling);
}
else if (fighter2abl1Stat == "dexterity") {
    fighter2abl1Damage = Number(fighter2abl1Damage) + ((fighter2Dexterity - fighter2abl1ScalingReq) * fighter2abl1Scaling);
}
else if (fighter2abl1Stat == "constitution") {
    fighter2abl1Damage = Number(fighter2abl1Damage) + ((fighter2Constitution - fighter2abl1ScalingReq) * fighter2abl1Scaling);
}
else if (fighter2abl1Stat == "wisdom") {
    fighter2abl1Damage = Number(fighter2abl1Damage) + ((fighter2Wisdom - fighter2abl1ScalingReq) * fighter2abl1Scaling);
}
else if (fighter2abl1Stat == "intelligence") {
    fighter2abl1Damage = Number(fighter2abl1Damage) + ((fighter2Intelligence - fighter2abl1ScalingReq) * fighter2abl1Scaling);
}
else if (fighter2abl1Stat == "charisma") {
    fighter2abl1Damage = Number(fighter2abl1Damage) + ((fighter2Charisma - fighter2abl1ScalingReq) * fighter2abl1Scaling);

}

//fighter 2 skill 2
var fighter2abl2healing = 0;
var fighter2abl2Damage = 4;
var fighter2abl2Stat = "strength";
var fighter2abl2Scaling = 2;
var fighter2abl2ScalingReq = 15;
var fighter2abl2ManaCost = 8;
if (fighter2abl2Stat == "strength") {

    fighter2abl2Damage = Number(fighter2abl2Damage) + ((fighter2Strength - fighter2abl2ScalingReq) * fighter2abl2Scaling);
}
else if (fighter2abl2Stat == "dexterity") {
    fighter2abl2Damage = Number(fighter2abl2Damage) + ((fighter2Dexterity - fighter2abl2ScalingReq) * fighter2abl2Scaling);
}
else if (fighter2abl2Stat == "constitution") {
    fighter2abl2Damage = Number(fighter2abl2Damage) + ((fighter2Constitution - fighter2abl2ScalingReq) * fighter2abl2Scaling);
}
else if (fighter2abl2Stat == "wisdom") {
    fighter2abl2Damage = Number(fighter2abl2Damage) + ((fighter2Wisdom - fighter2abl2ScalingReq) * fighter2abl2Scaling);
}
else if (fighter2abl2Stat == "intelligence") {
    fighter2abl2Damage = Number(fighter2abl2Damage) + ((fighter2Intelligence - fighter2abl2ScalingReq) * fighter2abl2Scaling);
}
else if (fighter2abl2Stat == "charisma") {
    fighter2abl2Damage = Number(fighter2abl2Damage) + ((fighter2Charisma - fighter2abl2ScalingReq) * fighter2abl2Scaling);

}

//fighter 2 skill 3
var fighter2abl3healing = 1;
var fighter2abl3Damage = 25;
var fighter2abl3Stat = "wisdom";
var fighter2abl3Scaling = 0;
var fighter2abl3ScalingReq = 18;
var fighter2abl3ManaCost = 25;
if (fighter2abl3Stat == "strength") {
    fighter2abl3Damage = Number(fighter2abl3Damage) + ((fighter2Strength - fighter2abl3ScalingReq) * fighter2abl3Scaling);
}
else if (fighter2abl3Stat == "dexterity") {
    fighter2abl3Damage = Number(fighter2abl3Damage) + ((fighter2Dexterity - fighter2abl3ScalingReq) * fighter2abl3Scaling);
}
else if (fighter2abl3Stat == "constitution") {
    fighter2abl3Damage = Number(fighter2abl3Damage) + ((fighter2Constitution - fighter2abl3ScalingReq) * fighter2abl3Scaling);
}
else if (fighter2abl3Stat == "wisdom") {
    fighter2abl3Damage = Number(fighter2abl3Damage) + ((fighter2Wisdom - fighter2abl3ScalingReq) * fighter2abl3Scaling);
}
else if (fighter2abl3Stat == "intelligence") {
    fighter2abl3Damage = Number(fighter2abl3Damage) + ((fighter2Intelligence - fighter2abl3ScalingReq) * fighter2abl3Scaling);
}
else if (fighter2abl3Stat == "charisma") {
    fighter2abl3Damage = Number(fighter2abl3Damage) + ((fighter2Charisma - fighter2abl3ScalingReq) * fighter2abl3Scaling);
}

var turn = 1;
if (fighter2Dexterity > fighter1Dexterity) {
    turn = 2;
}


function basicAttack() {
    if (turn === 1) {
        var curhp = Number(document.getElementById("health2").innerHTML);
        if ((curhp - Math.floor(fighter1Strength / 2)) < 0) {
            document.getElementById("health2").innerHTML = 0;
            onWin();
            return;
        } else {
            document.getElementById("health2").innerHTML -= Math.floor(fighter1Strength / 2);
        }
        var redPer = (document.getElementById("health2").innerHTML / document.getElementById("maxHealth2").innerHTML) * 100;
        var whitePer = 100 - redPer;
        console.log(redPer);
        document.getElementById('hp2').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
        document.getElementById("fighter2").classList.add('shake');
        setTimeout(function () { document.getElementById("fighter2").classList.remove('shake') }, 500);
        turn = 2;
        setTimeout(botAttack, 3000);
    }

}

function abl1() {
    if (turn === 1) {
        var curmana = Number(document.getElementById("mana1").innerHTML);
        if (curmana >= abl1ManaCost) {
            if (abl1healing == 1) {
                var curhp = Number(document.getElementById("health1").innerHTML);
                if ((curhp + abl1Damage) > document.getElementById("maxHealth1").innerHTML) {
                    document.getElementById("health1").innerHTML = document.getElementById("maxHealth1").innerHTML;
                    document.getElementById("mana1").innerHTML -= abl1ManaCost;
                } else {
                    document.getElementById("health1").innerHTML = Number(document.getElementById("health1").innerHTML) + Number(abl1Damage);
                    document.getElementById("mana1").innerHTML -= abl1ManaCost;
                }
                var redPer = (document.getElementById("health1").innerHTML / document.getElementById("maxHealth1").innerHTML) * 100;
                var bluePar = (document.getElementById("mana1").innerHTML / document.getElementById("maxMana1").innerHTML) * 100;
                var whitePer = 100 - redPer;
                document.getElementById('hp1').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
                var whitePer = 100 - bluePar;
                document.getElementById('mp1').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
                document.getElementById("fighter1").classList.add('shake');
                setTimeout(function () { document.getElementById("fighter1").classList.remove('shake') }, 500);
                turn = 2;
                setTimeout(botAttack, 3000);
            } else {
                var curhp = Number(document.getElementById("health2").innerHTML);
                if ((curhp - abl1Damage) < 0) {
                    document.getElementById("health2").innerHTML = 0;
                    document.getElementById("mana1").innerHTML -= abl1ManaCost;
                    onWin();
                    return;
                } else {
                    document.getElementById("health2").innerHTML -= abl1Damage;
                    document.getElementById("mana1").innerHTML -= abl1ManaCost;
                }
                var redPer = (document.getElementById("health2").innerHTML / document.getElementById("maxHealth2").innerHTML) * 100;
                var bluePar = (document.getElementById("mana1").innerHTML / document.getElementById("maxMana1").innerHTML) * 100;
                var whitePer = 100 - redPer;
                console.log(redPer);
                console.log(bluePar);
                document.getElementById('hp2').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
                whitePer = 100 - bluePar;
                document.getElementById('mp1').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
                document.getElementById("fighter2").classList.add('shake');
                setTimeout(function () { document.getElementById("fighter2").classList.remove('shake') }, 500);
                turn = 2;
                setTimeout(botAttack, 3000);
            }
        }
    }

}

function abl2() {
    if (turn === 1) {
        var curmana = Number(document.getElementById("mana1").innerHTML);
        if (curmana >= abl2ManaCost) {
            if (abl2healing == 1) {
                var curhp = Number(document.getElementById("health1").innerHTML);
                if ((curhp + abl2Damage) > document.getElementById("maxHealth1").innerHTML) {
                    document.getElementById("health1").innerHTML = document.getElementById("maxHealth1").innerHTML;
                    document.getElementById("mana1").innerHTML -= abl2ManaCost;
                } else {
                    document.getElementById("health1").innerHTML = Number(document.getElementById("health1").innerHTML) + Number(abl2Damage);
                    document.getElementById("mana1").innerHTML -= abl2ManaCost;
                }
                var redPer = (document.getElementById("health1").innerHTML / document.getElementById("maxHealth1").innerHTML) * 100;
                var bluePar = (document.getElementById("mana1").innerHTML / document.getElementById("maxMana1").innerHTML) * 100;
                var whitePer = 100 - redPer;
                document.getElementById('hp1').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
                var whitePer = 100 - bluePar;
                document.getElementById('mp1').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
                document.getElementById("fighter1").classList.add('shake');
                setTimeout(function () { document.getElementById("fighter1").classList.remove('shake') }, 500);
                turn = 2;
                setTimeout(botAttack, 3000);
            } else {
                var curhp = Number(document.getElementById("health2").innerHTML);
                if ((curhp - abl2Damage) < 0) {
                    document.getElementById("health2").innerHTML = 0;
                    document.getElementById("mana1").innerHTML -= abl2ManaCost;
                    onWin();
                    return;
                } else {
                    document.getElementById("health2").innerHTML -= abl2Damage;
                    document.getElementById("mana1").innerHTML -= abl2ManaCost;
                }
                var redPer = (document.getElementById("health2").innerHTML / document.getElementById("maxHealth2").innerHTML) * 100;
                var bluePar = (document.getElementById("mana1").innerHTML / document.getElementById("maxMana1").innerHTML) * 100;
                var whitePer = 100 - redPer;
                console.log(redPer);
                console.log(bluePar);
                document.getElementById('hp2').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
                whitePer = 100 - bluePar;
                document.getElementById('mp1').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
                document.getElementById("fighter2").classList.add('shake');
                setTimeout(function () { document.getElementById("fighter2").classList.remove('shake') }, 500);
                turn = 2;
                setTimeout(botAttack, 3000);
            }
        }
    }

}

function abl3() {
    if (turn === 1) {
        var curmana = Number(document.getElementById("mana1").innerHTML);
        if (curmana >= abl3ManaCost) {
            if (abl3healing == 1) {
                var curhp = Number(document.getElementById("health1").innerHTML);
                if ((curhp + abl3Damage) > document.getElementById("maxHealth1").innerHTML) {
                    document.getElementById("health1").innerHTML = document.getElementById("maxHealth1").innerHTML;
                    document.getElementById("mana1").innerHTML -= abl3ManaCost;
                } else {
                    document.getElementById("health1").innerHTML = Number(document.getElementById("health1").innerHTML) + Number(abl3Damage);
                    document.getElementById("mana1").innerHTML -= abl3ManaCost;
                }
                var redPer = (document.getElementById("health1").innerHTML / document.getElementById("maxHealth1").innerHTML) * 100;
                var bluePar = (document.getElementById("mana1").innerHTML / document.getElementById("maxMana1").innerHTML) * 100;
                var whitePer = 100 - redPer;
                document.getElementById('hp1').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
                var whitePer = 100 - bluePar;
                document.getElementById('mp1').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
                document.getElementById("fighter1").classList.add('shake');
                setTimeout(function () { document.getElementById("fighter1").classList.remove('shake') }, 500);
                turn = 2;
                setTimeout(botAttack, 3000);
            } else {
                var curhp = Number(document.getElementById("health2").innerHTML);
                if ((curhp - abl3Damage) < 0) {
                    document.getElementById("health2").innerHTML = 0;
                    document.getElementById("mana1").innerHTML -= abl3ManaCost;
                    onWin();
                    return;
                } else {
                    document.getElementById("health2").innerHTML -= abl3Damage;
                    document.getElementById("mana1").innerHTML -= abl3ManaCost;
                }
                var redPer = (document.getElementById("health2").innerHTML / document.getElementById("maxHealth2").innerHTML) * 100;
                var bluePar = (document.getElementById("mana1").innerHTML / document.getElementById("maxMana1").innerHTML) * 100;
                var whitePer = 100 - redPer;
                console.log(redPer);
                console.log(bluePar);
                document.getElementById('hp2').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
                whitePer = 100 - bluePar;
                document.getElementById('mp1').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
                document.getElementById("fighter2").classList.add('shake');
                setTimeout(function () { document.getElementById("fighter2").classList.remove('shake') }, 500);
                turn = 2;
                setTimeout(botAttack, 3000);
            }
        }
    }

}


function botAttack() {
    var attack = Math.floor(Math.random() * 4) + 1;
    var curmana = Number(document.getElementById("mana2").innerHTML);

    //basic attack
    if (attack === 1) {
        var curhp = Number(document.getElementById("health1").innerHTML);
        if ((curhp - Math.floor(fighter2Strength / 2)) < 0) {
            document.getElementById("health1").innerHTML = 0;
            onLose();
        } else {
            document.getElementById("health1").innerHTML -= Math.floor(fighter2Strength / 2);
        }
        var redPer = (document.getElementById("health1").innerHTML / document.getElementById("maxHealth1").innerHTML) * 100;
        var whitePer = 100 - redPer;
        console.log(redPer);
        console.log(bluePar);
        document.getElementById('hp1').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
        document.getElementById("fighter1").classList.add('shake');
        setTimeout(function () { document.getElementById("fighter1").classList.remove('shake') }, 500);
        turn = 1;
    }

    //skill 1
    else if (attack === 2) {
        if (curmana >= fighter2abl1ManaCost) {
            if (fighter2abl1healing == 1) {
                var curhp = Number(document.getElementById("health2").innerHTML);
                if ((curhp + fighter2abl1Damage) > document.getElementById("maxHealth2").innerHTML) {
                    document.getElementById("health2").innerHTML = document.getElementById("maxHealth2").innerHTML;
                    document.getElementById("mana2").innerHTML -= fighter2abl1ManaCost;
                } else {
                    document.getElementById("health2").innerHTML = Number(document.getElementById("health2").innerHTML) + Number(fighter2abl1Damage);
                    document.getElementById("mana2").innerHTML -= fighter2abl1ManaCost;
                }
                var redPer = (document.getElementById("health2").innerHTML / document.getElementById("maxHealth2").innerHTML) * 100;
                var bluePar = (document.getElementById("mana2").innerHTML / document.getElementById("maxMana2").innerHTML) * 100;
                var whitePer = 100 - redPer;
                document.getElementById('hp2').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
                var whitePer = 100 - bluePar;
                document.getElementById('mp2').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
                document.getElementById("fighter2").classList.add('shake');
                setTimeout(function () { document.getElementById("fighter2").classList.remove('shake') }, 500);
                turn = 1;
            } else {
                var curhp = Number(document.getElementById("health1").innerHTML);
                if ((curhp - fighter2abl1Damage) < 0) {
                    document.getElementById("health1").innerHTML = 0;
                    document.getElementById("mana2").innerHTML -= fighter2abl1ManaCost;
                    onLose();
                } else {
                    document.getElementById("health1").innerHTML -= fighter2abl1Damage;
                    document.getElementById("mana2").innerHTML -= fighter2abl1ManaCost;
                }
                var redPer = (document.getElementById("health1").innerHTML / document.getElementById("maxHealth1").innerHTML) * 100;
                var bluePar = (document.getElementById("mana2").innerHTML / document.getElementById("maxMana2").innerHTML) * 100;
                var whitePer = 100 - redPer;
                console.log(redPer);
                console.log(bluePar);
                document.getElementById('hp1').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
                whitePer = 100 - bluePar;
                document.getElementById('mp2').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
                document.getElementById("fighter1").classList.add('shake');
                setTimeout(function () { document.getElementById("fighter1").classList.remove('shake') }, 500);
                turn = 1;
            }
        } else {
            botAttack();
        }
    }

    //skill 2
    else if (attack === 3) {
        if (curmana >= fighter2abl2ManaCost) {
            if (fighter2abl2healing == 1) {
                var curhp = Number(document.getElementById("health2").innerHTML);
                if ((curhp + fighter2abl2Damage) > document.getElementById("maxHealth2").innerHTML) {
                    document.getElementById("health2").innerHTML = document.getElementById("maxHealth2").innerHTML;
                    document.getElementById("mana2").innerHTML -= fighter2abl2ManaCost;
                } else {
                    document.getElementById("health2").innerHTML = Number(document.getElementById("health2").innerHTML) + Number(fighter2abl2Damage);
                    document.getElementById("mana2").innerHTML -= fighter2abl2ManaCost;
                }
                var redPer = (document.getElementById("health2").innerHTML / document.getElementById("maxHealth2").innerHTML) * 100;
                var bluePar = (document.getElementById("mana2").innerHTML / document.getElementById("maxMana2").innerHTML) * 100;
                var whitePer = 100 - redPer;
                document.getElementById('hp2').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
                var whitePer = 100 - bluePar;
                document.getElementById('mp2').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
                document.getElementById("fighter2").classList.add('shake');
                setTimeout(function () { document.getElementById("fighter2").classList.remove('shake') }, 500);
                turn = 1;
            } else {
                var curhp = Number(document.getElementById("health1").innerHTML);
                if ((curhp - fighter2abl2Damage) < 0) {
                    document.getElementById("health1").innerHTML = 0;
                    document.getElementById("mana2").innerHTML -= fighter2abl2ManaCost;
                    onLose();
                } else {
                    document.getElementById("health1").innerHTML -= fighter2abl2Damage;
                    document.getElementById("mana2").innerHTML -= fighter2abl2ManaCost;
                }
                var redPer = (document.getElementById("health1").innerHTML / document.getElementById("maxHealth1").innerHTML) * 100;
                var bluePar = (document.getElementById("mana2").innerHTML / document.getElementById("maxMana2").innerHTML) * 100;
                var whitePer = 100 - redPer;
                console.log(redPer);
                console.log(bluePar);
                document.getElementById('hp1').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
                whitePer = 100 - bluePar;
                document.getElementById('mp2').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
                document.getElementById("fighter1").classList.add('shake');
                setTimeout(function () { document.getElementById("fighter1").classList.remove('shake') }, 500);
                turn = 1;
            }
        } else {
            botAttack();
        }
    }

    //skill 3
    else if (attack === 4) {
        if (curmana >= fighter2abl3ManaCost) {
            if (fighter2abl3healing === 1) {
                var curhp = Number(document.getElementById("health2").innerHTML);
                if ((curhp + fighter2abl3Damage) > document.getElementById("maxHealth2").innerHTML) {
                    document.getElementById("health2").innerHTML = document.getElementById("maxHealth2").innerHTML;
                    document.getElementById("mana2").innerHTML -= fighter2abl3ManaCost;
                } else {
                    document.getElementById("health2").innerHTML = Number(document.getElementById("health2").innerHTML) + Number(fighter2abl3Damage);
                    document.getElementById("mana2").innerHTML -= fighter2abl3ManaCost;
                }
                var redPer = (document.getElementById("health2").innerHTML / document.getElementById("maxHealth2").innerHTML) * 100;
                var bluePar = (document.getElementById("mana2").innerHTML / document.getElementById("maxMana2").innerHTML) * 100;
                var whitePer = 100 - redPer;
                document.getElementById('hp2').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
                var whitePer = 100 - bluePar;
                document.getElementById('mp2').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
                document.getElementById("fighter2").classList.add('shake');
                setTimeout(function () { document.getElementById("fighter2").classList.remove('shake') }, 500);
                turn = 1;
            } else {
                var curhp = Number(document.getElementById("health1").innerHTML);
                if ((curhp - fighter2abl3Damage) < 0) {
                    document.getElementById("health1").innerHTML = 0;
                    document.getElementById("mana2").innerHTML -= fighter2abl3ManaCost;
                    onLose();
                } else {
                    document.getElementById("health1").innerHTML -= fighter2abl3Damage;
                    document.getElementById("mana2").innerHTML -= fighter2abl3ManaCost;
                }
                var redPer = (document.getElementById("health1").innerHTML / document.getElementById("maxHealth1").innerHTML) * 100;
                var bluePar = (document.getElementById("mana2").innerHTML / document.getElementById("maxMana2").innerHTML) * 100;
                var whitePer = 100 - redPer;
                console.log(redPer);
                console.log(bluePar);
                document.getElementById('hp1').style.background = 'linear-gradient(to right , red ' + redPer + '%, white ' + whitePer + '%)';
                whitePer = 100 - bluePar;
                document.getElementById('mp2').style.background = 'linear-gradient(to right , blue ' + bluePar + '%, white ' + whitePer + '%)';
                document.getElementById("fighter1").classList.add('shake');
                setTimeout(function () { document.getElementById("fighter1").classList.remove('shake') }, 500);
                turn = 1;
            }
        } else {
            botAttack();
        }

    }
  }
}


window.twttr = (function (d, s, id) {
  var js,
    fjs = d.getElementsByTagName(s)[0],
    t = window.twttr || {};
  if (d.getElementById(id)) return t;
  js = d.createElement(s);
  js.id = id;
  js.src = "https://platform.twitter.com/widgets.js";
  fjs.parentNode.insertBefore(js, fjs);

  t._e = [];
  t.ready = function (f) {
    t._e.push(f);
  };

  return t;
})(document, "script", "twitter-wjs");

function onWin() {
  document.getElementById("overlay").style.display = "flex";
  document.getElementById("winOrLose").innerHTML = "!!! YOU WIN !!!";
  window.open(
    <a
      target="_blank"
      class="twitter-share-button"
      href="https://twitter.com/intent/tweet?text=Victory tastes like tacos, i just cat squished a doodle warrior on JavaDoodleDuels, come join the fight!!"
      data-size="large"
    ></a>
  );
}

function onLose() {
  document.getElementById("overlay").style.display = "flex";
  document.getElementById("winOrLose").innerHTML = "!!! YOU LOSE !!!";
  window.open(
    <a
      target="_blank"
      class="twitter-share-button"
      href="https://twitter.com/intent/tweet?text=Victory tastes like tacos, i just cat squished a doodle warrior on JavaDoodleDuels, come join the fight!!"
      data-size="large"
    ></a>
  );
}

function off() {
  document.getElementById("overlay").style.display = "none";
}

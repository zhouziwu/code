
function createCode(length) {
    var code = "";
    var codeLength = parseInt(length); //验证码的长度
    var checkCode = document.getElementById("checkCode");
    var checkCode1 = document.getElementById("checkCode1");
    var checkCode2 = document.getElementById("checkCode2");
    var checkCode3 = document.getElementById("checkCode3");
    var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
    for (var i = 0; i < codeLength; i++) {
        var charNum = Math.floor(Math.random() * 62);
        code += codeChars[charNum];
    }
    if (checkCode) {
        checkCode.className = "code";
        checkCode.innerHTML = code;
    }
    if (checkCode1) {
        checkCode1.className = "code";
        checkCode1.innerHTML = code;
    }
    if (checkCode2) {
        checkCode2.className = "code";
        checkCode2.innerHTML = code;
    }
    if (checkCode3) {
        checkCode3.className = "code";
        checkCode3.innerHTML = code;
    }
}
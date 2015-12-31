/**
 * email 검증 JS
 */

function validateForm() {
	var regex_email = /^([\w\.-]+)@([a-z\d\.-]+)\.([a-z\.]{2,6})$/;
    var email = $("#email");
    
    
    if(regex_email.test(email.val()) != true) { // 이메일 검사
		alert('[Email 입력 오류] 유효한 이메일 주소를 입력해 주세요.');
		email.focus();
		return false;
    }
}
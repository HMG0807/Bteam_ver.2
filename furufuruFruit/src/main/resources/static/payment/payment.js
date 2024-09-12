let cardslash = document.querySelector(".paymentbtn")
cardslash.addEventListener('click', function(){
    alert("결제되었습니다.");
    location.href = "/mypage/order";
})
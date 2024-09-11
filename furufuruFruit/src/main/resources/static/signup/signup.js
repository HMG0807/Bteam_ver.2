// 도메인 직접 입력 or domain option 선택
const domainListEl = document.querySelector('#domain-list')
const domainInputEl = document.querySelector('#domain-txt')

const formtest = document.signUpForm[6];

console.log(formtest)


// select 옵션 변경 시
domainListEl.addEventListener('change', (event) => {
  // option에 있는 도메인 선택 시
  if(event.target.value !== "type") {
    // 선택한 도메인을 input에 입력하고 disabled
    domainInputEl.value = event.target.value
    domainInputEl.disabled = true
  } else { // 직접 입력 시
    // input 내용 초기화 & 입력 가능하도록 변경
    domainInputEl.value = ""
    domainInputEl.disabled = false
  }
})


const autoHyphen = (target) => {
  target.value = target.value
   .replace(/[^0-9]/g, '')
   .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}

function findAddr1(){

    new daum.Postcode({
      
      oncomplete: function(data) {
          console.log(data);
        
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
          // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var roadAddr = data.roadAddress; // 도로명 주소 변수
          var jibunAddr = data.jibunAddress; // 지번 주소 변수
          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          document.getElementById('member_post').value = data.zonecode;
          if(roadAddr !== ''){
              document.getElementById("member_addr").value = roadAddr;
          } 
          else if(jibunAddr !== ''){
              document.getElementById("member_addr").value = jibunAddr;
          }
          document.getElementById("member_addr_in").focus();

      }
  }).open();


}

document.addEventListener('keydown', function(event) {
  if (event.keyCode === 13) {
    event.preventDefault();
  };
}, true);

const signupForm = document.querySelector("#signUpForm");
const searchbtn = document.querySelector("#btn-post");

function signupSubmit(event) {
  event.preventDefault();
  console.log(event);
}

searchbtn.addEventListener("click", signupSubmit);

let btn = document.querySelector(".signupbtn");
const signUpFormBtn = document.signUpForm;

btn.addEventListener('click', function(){
  domainInputEl.disabled = false
  document.signUpFormBtn.submit();

})
const aa = {
    a: "a변수입니다",
    b: "b는 20입니다",
    c: "c변수입니다"
}

const {a, b, c} = aa;

console.log(`a = ${a}`);
console.log(`b = ${b}`);
console.log(`c = ${c}`);


// 오래된 회사는 보통 50~60%정도 제이쿼리
//jquery -> ajax(); json 비동기 통신

// 신규 개발
// javascript -> vue
// javascript -> react ->
// Node -> typescript -> next.js axiosX fetch()O
// 문자열로 만드는 함수 JSON.stringfy();
// 문자열을 다시 객체로 만드는 함수 JSON.parse();
const aaa = JSON.stringify(aa);
console.log(JSON.parse(aaa));
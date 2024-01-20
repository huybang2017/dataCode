let textsoA = document.querySelector("#TextsoA");
let textsoB = document.querySelector("#TextsoB");
let textKetQua = document.querySelector("#TextKetQua");
let regexNum = /^-?\d+(\.\d+)?$/;

const validate = (textSo) => {
  if (textSo.value === "") {
    alert("dữ liệu rỗng");
    textSo.focus();
    return false;
  } else if (!textSo.value.match(regexNum)) {
    alert("dữ liệu không phải là số");
    textSo.value = "";
    textSo.focus();
    return false;
  }
  return true;
};
document.querySelector("#tong").addEventListener("click", () => {
  let ketqua = 0;
  let isValidSoA = validate(textsoA);
  if (!isValidSoA) return;
  let isValidSoB = validate(textsoB);
  if (!isValidSoB) return;

  ketqua = (+textsoA.value + +textsoB.value).toFixed(3);
  textKetQua.value = ketqua;
});
document.querySelector("#hieu").addEventListener("click", () => {
  let ketqua = 0;
  let isValidSoA = validate(textsoA);
  if (!isValidSoA) return;
  let isValidSoB = validate(textsoB);
  if (!isValidSoB) return;

  ketqua = (+textsoA.value - +textsoB.value).toFixed(3);
  console.log(typeof +textsoA.value);
  textKetQua.value = ketqua;
});
document.querySelector("#tich").addEventListener("click", () => {
  let ketqua = 0;
  let isValidSoA = validate(textsoA);
  if (!isValidSoA) return;
  let isValidSoB = validate(textsoB);
  if (!isValidSoB) return;

  ketqua = (+textsoA.value * +textsoB.value).toFixed(3);
  console.log(typeof +textsoA.value);
  textKetQua.value = ketqua;
});
document.querySelector("#thuong").addEventListener("click", () => {
  let ketqua = 0;
  let isValidSoA = validate(textsoA);
  if (!isValidSoA) return;
  let isValidSoB = validate(textsoB);
  if (!isValidSoB) return;
  if (+textsoB.value === 0) {
    textKetQua.value = "lỗi phép chia số B phải khác 0";
    return;
  }
  ketqua = (+textsoA.value / +textsoB.value).toFixed(3);
  textKetQua.value = ketqua;
});

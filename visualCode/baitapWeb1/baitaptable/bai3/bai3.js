let txtHoten = document.querySelector("#txtHoten");
let txtCmnd = document.querySelector("#txtCmnd");
let chkAnsang = document.querySelector("#chkAnsang");
let chkGiatui = document.querySelector("#chkGiatui");
let chkBaobuoisang = document.querySelector("#chkBaobuoisang");
let cboMucgia = document.querySelector("#cboMucgia");
let dateNgaythue = document.querySelector("#dateNgaythue");
let dateNgaytra = document.querySelector("#dateNgaytra");
let txtTienthuephong = document.querySelector("#txtTienthuephong");
document.querySelector("#subDangky").addEventListener("click", () => {
  let regexCmnd = /^\d+$/;
  if (txtHoten.value === "") {
    alert("Họ tên không được rỗng");
    txtHoten.focus();
    return;
  }

  if (txtCmnd.value === "") {
    alert("CMND không được rỗng");
    txtCmnd.focus();
    return;
  } else if (!txtCmnd.value.match(regexCmnd)) {
    alert("CMND phải là số");
    txtCmnd.focus();
    return;
  }
});

document.querySelector("#cboMucgia").addEventListener("change", () => {
  if (cboMucgia.value === "b" || cboMucgia.value === "c") {
    chkAnsang.checked = true;
  } else {
    chkAnsang.checked = false;
  }
});

document.querySelector("#btnTinhdongia").addEventListener("click", () => {
  let ngaythue = new Date(dateNgaythue.value);
  let ngaytra = new Date(dateNgaytra.value);
  let date;
  let tienThue1Ngay;
  let dichVu = 0;

  console.log(ngaythue.getTime(), ngaytra.getTime());
  if (dateNgaythue.value === "" || dateNgaytra.value === "") {
    date = 1;
  } else if (ngaythue.getTime() === ngaytra.getTime()) {
    date = 1;
  } else if (ngaythue.getTime() > ngaytra.getTime()) {
    date = -10;
    alert("ngày trả phải sau ngày thuê");
  } else {
    date = (ngaytra - ngaythue) / (24 * 60 * 60 * 1000);
  }

  switch (cboMucgia.value) {
    case "a":
      tienThue1Ngay = 150000;
      break;
    case "b":
      tienThue1Ngay = 300000;
      break;
    case "c":
      tienThue1Ngay = 500000;
      break;
  }

  if (chkAnsang.checked) {
    if (cboMucgia.value === "a") {
      dichVu += 0.05;
    } else {
      dichVu = 0;
    }
  }

  if (chkGiatui.checked) {
    dichVu += 0.05;
  }

  if (chkBaobuoisang.checked) {
    dichVu += 0.05;
  }

  if (date === -10) {
    return;
  } else {
    txtTienthuephong.value = tienThue1Ngay * date + tienThue1Ngay * dichVu;
  }
});

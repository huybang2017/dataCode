// tôi là Huy

var fullName = 'Nguyễn Đức Huy';
var age = 18;
alert(fullName);
alert(age);

console.log('tôi là Huy'); //in ra thông báo ở console
confirm('xác nhận bạn đã đủ 18 tuổi chưa'); // thông báo cho user xác nhận thường dùng để xác nhận tuổi]
prompt('nhập độ tuổi của bạn'); //lấy giá trị của người dùng vào rồi xác nhận
setTimeout(function() {
    alert('hoàn thành hẹn giờ');
}, 2000); //hẹn giờ thực hiện lệnh sau 1 khoảng thời gian
setInterval(function() {
    console.log('day la Log' + Math.ramdom()
}, 1000); //sau 1 giây chu kì in ra đây là log
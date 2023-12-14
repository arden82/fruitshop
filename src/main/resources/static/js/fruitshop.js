document.addEventListener("DOMContentLoaded", function() {
	let ajaxwrap = document.querySelector(".ajaxwrap");
	fetch("/products", { method: "GET" }).then(res => res.json()).then(data => {
		console.log(data);
		let str = "";
		data.forEach(e => {
			str += `<div class="card" style="width: 18rem;">
				<img src="/img/${e.productname}.jpg" class="card-img-top" alt="${e.productname}圖">
				<div class="card-body d-flex flex-column justify-content-around">
					<h5 class="card-title text-center">${e.productname}</h5>
					<div class=" d-flex justify-content-between">
						<div class=" wrap d-flex justify-content-center">
							<input type="button" value="-" class="minus"> <input
								class="writeunit" type="text" name="apple" id="apple" value="1">
							<input type="button" value="+" class="plus">
						</div>
						<input type="button" value="購物" class="btn btn-primary add">
					</div>
					<div class="minwrap d-flex justify-content-between">
						<span class="tip"></span>
						<h6>
							價格$<span class="price">${e.price}</span>/<span class="unitstr">${e.unit}</span>
						</h6>
					</div>
						</div>
				</div>`;
		});

		ajaxwrap.innerHTML += str;
		let checkout = document.querySelector(".checkout");
		console.log(checkout);
		checkout.addEventListener("click", function() {
			username = document.querySelector(".usrname").value;
			const regexstr = /^[\u4e00-\u9fa5]{2,}$/;
			let valid = regexstr.test(username);
			if (valid) {
				let formData = new FormData();
				let flist = [];
				let newli = carlist.querySelectorAll("li")//新增後lis
				let strdetail = "";
				if (newli.length > 0) {
					for (let k = 0; k < newli.length; k++) {
						let productname = newli[k].querySelector(".liname").textContent;
						let quantity = newli[k].querySelector(".quantity").textContent;
						let unit = "";
						for (let h = 0; h < productNames.length; h++) {
							if (productname == productNames[h].textContent) {
								console.log(unitstr[h]);
								unit = unitstr[h].textContent;
							}
						}
						console.log(unit);
						quantity = parseInt(quantity, 10);
						flist.push({ "productname": productname, "quantity": quantity });
						strdetail += `${productname}${quantity}${unit},`;
					}
					strdetail += `總計${total.textContent}元，感謝您的消費`;
					formData.append("username", username);
					formData.append("flist", flist);
					fetch("/order", {
						method: "post",
						body: formData
					}).then(res => res.json()).then(data => {
						console.log("成功送出", data);
						for (let i = 0; i < writeunitlist.length; i++) {
							writeunitlist[i].value = 1;
						}
						alert(`${username}你好，您總共購買${strdetail}`);
						carlist.innerHTML = "";
						total.innerHTML = "";
						document.querySelector(".usrname").value = "";

					}).catch(err => console.err("err", err))

				}
			} else {
				alert("購買人資料不正確，請輸入中文名字至少兩個字")
				document.querySelector(".usrname").value = "";
			}
		})
		let wraplist = document.querySelectorAll(".wrap");
		let addbtn = document.querySelectorAll(".add");
		let productNames = document.querySelectorAll("h5");
		let prices = document.querySelectorAll(".price");
		let carlist = document.querySelector(".carlist");
		let total = document.querySelector(".total");
		let writeunitlist = document.querySelectorAll(".writeunit");
		let unitstr = document.querySelectorAll(".unitstr");
		let username = document.querySelector(".usrname");
		for (let i = 0; i < wraplist.length; i++) {
			wraplist[i].addEventListener("click", function(e) {
				let action = e.target.className;
				let parent = e.target.closest(".wrap");
				unit = parent.querySelector(".writeunit").value;
				unit = parseInt(unit, 10);
				if (action == "plus" && unit < 10) {
					unit += 1;
					parent.querySelector(".writeunit").value = unit
				} else if (action == "minus" && unit != 1) {
					unit -= 1;
					parent.querySelector(".writeunit").value = unit;
				}

			})
			addbtn[i].addEventListener("click", function() {
				let unit = wraplist[i].querySelector(".writeunit");
				let price = prices[i].textContent;
				unit = unit.value;
				let productName = productNames[i].textContent;
				let lis = carlist.querySelectorAll("li");//訂單裡的li
				let list; //訂單裡的商品名


				if (lis.length > 0) {
					let same = false;
					list = carlist.querySelectorAll(".liname");
					for (let j = 0; j < list.length; j++) {
						if (productName == list[j].textContent) {
							same = true;
							lis[j].querySelector(".carwrap").innerHTML = `<div class="carwrap"><span class="liname">${productName}</span>x<span class="quantity">${unit}</span>小計<span class="carprice  ml-1">${unit * price}</span></div>`;

						}
					}
					if (!same) {
						let newListItem = document.createElement("li");
						newListItem.className = "carunit";
						newListItem.innerHTML = `<div class="carwrap"><span class="liname">${productName}</span>x<span class="quantity">${unit}</span>小計<span class="carprice  ml-1">${unit * price}</span></div>`;
						carlist.appendChild(newListItem);

					}

				} else {
					let newListItem = document.createElement("li");
					newListItem.className = "carunit";
					newListItem.innerHTML = `<div class="carwrap"><span class="liname">${productName}</span>x<span class="quantity">${unit}</span>小計<span class="carprice ml-1">${unit * price}</span></div>`;
					carlist.appendChild(newListItem);
				}
				let sums = 0;
				let newli = carlist.querySelectorAll("li")//新增後li
				for (let k = 0; k < newli.length; k++) {
					let sum = newli[k].querySelector(".carprice").textContent;
					sum = parseInt(sum, 10);
					sums += sum;
				}
				total.textContent = sums;
			})


		}

	})

});



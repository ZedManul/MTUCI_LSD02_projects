const menuBtn = document.querySelector(".menu__btn");
const menuList = document.querySelector(".menu__list");

function toggleMenuVisibility() {
menuList.classList.toggle("hide");
}

menuBtn.addEventListener("click", toggleMenuVisibility);



const portfolioLink = document.querySelector(".portfolio__link");
const portfolioBtn = document.querySelector(".portfolio__btn");
const portfolioContent = document.querySelector(".portfolio__content");

function togglePortfolioVisibility() {
portfolioContent.classList.toggle("hide");
}

portfolioBtn.addEventListener("click", togglePortfolioVisibility);
portfolioLink.addEventListener("click", togglePortfolioVisibility);

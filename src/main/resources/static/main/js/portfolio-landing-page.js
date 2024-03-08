// darkmode
const darkmode = document.querySelector(".darkmode-toggle");
const darkmodeIcon = document.querySelector(".darkmode-toggle > i");

const enableDarkmode = () => {
    document.body.classList.add("darkmode");
    darkmodeIcon.classList.remove("bi-sun");
    darkmodeIcon.classList.add("bi-moon");
    localStorage.setItem("darkmode", "enabled");
};

const disableDarkmode = () => {
    document.body.classList.remove("darkmode");
    darkmodeIcon.classList.remove("bi-moon");
    darkmodeIcon.classList.add("bi-sun");
    localStorage.setItem("darkmode", null);
};

if(localStorage.getItem("darkmode") === "enabled")
    enableDarkmode();

darkmode.addEventListener("click", () => {
    let darkmodeStorageValue = localStorage.getItem("darkmode");
    if(darkmodeStorageValue !== "enabled")
        enableDarkmode();
    else
        disableDarkmode();
});


// make scroll top toggle
const scrollTop = document.querySelector(".scroll-top");

setInterval(() => {
    if(window.pageYOffset > window.visualViewport.height/2)
    {
        scrollTop.style.display = "block";
    }
    else {
        scrollTop.style.display = "none";
    }
}, 100);


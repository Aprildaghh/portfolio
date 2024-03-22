$(function () {
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


    // resume modal close and open
    const resumeBtn = document.querySelector(".nav-resume");
    const blurModal = document.querySelector(".resume-modal-blur");
    const resumeModal = document.querySelector(".resume-modal");

    resumeBtn.addEventListener("click", () => {
        $(".resume-modal-blur").fadeIn(500);
        $(".resume-modal").fadeIn(500);
        blurModal.style.display = "block";
        resumeModal.style.display = "flex";

    })

    resumeModal.addEventListener("click", ()=> {
        $(".resume-modal-blur").fadeOut(500);
        $(".resume-modal").fadeOut(500);
        setTimeout(()=> {
            blurModal.style.display = "none";
            resumeModal.style.display = "none";
        }, 500);
    })

    // hamburger list
    const listIcon = document.querySelector(".list-icon");
    const iIcon = document.querySelector(".list-icon i");
    const navList = document.querySelector("nav ul");
    const navAbout = document.getElementById("nav-about");
    const navProjects = document.getElementById("nav-projects");
    const navContact = document.getElementById("nav-contact");

    function hideMenu() {
        // change the class
        iIcon.classList.remove("bi-x");
        iIcon.classList.add("bi-list");
        console.log("asd")
        // close menu
        navList.style.left = "-100%";
    }

    function showMenu() {
        // change the class
        iIcon.classList.remove("bi-list");
        iIcon.classList.add("bi-x");

        // open menu
        navList.style.left = "0";
    }

    listIcon.addEventListener("click", () => {
        if(iIcon.classList.contains("bi-list"))
            showMenu();
        else 
            hideMenu();
    })
    
    document.querySelector("nav ul li").addEventListener("click", hideMenu);
    navAbout.addEventListener("click", hideMenu);
    navProjects.addEventListener("click", hideMenu);
    navContact.addEventListener("click", hideMenu);

})

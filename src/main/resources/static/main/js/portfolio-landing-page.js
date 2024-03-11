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
    const resumeBtn = document.getElementById("nav-resume");
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

    // TODO: check the inputs and enable/disable the submit button according to validations
    const usernameInput = document.getElementById("username");
    const emailInput = document.getElementById("email");
    const messageInput = document.getElementById("message");
    const submitBtn = document.getElementById("contact-submit");
    const regex = /^[a-z0-9]+@[a-z]+\.[a-z]{2,3}$/;

    function isEmpty(e) {
        return (typeof e === "string" && e.length === 0) || (e === null)
    }

    setInterval(() => {
        if(isEmpty(usernameInput.value) && isEmpty(messageInput.value) && regex.test(emailInput.value))
        {
            console.log("dsa")
            submitBtn.disabled = "false";
        }
        else
        {
            console.log("asd")
            submitBtn.disabled = "false";
        }


    }, 1000);

    // TODO: create a modal if the url has emailsent

    // TODO: create error messages if the url has wrong-credentials

})

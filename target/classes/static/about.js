// about.js

document.addEventListener("DOMContentLoaded", () => {
  const observer = new IntersectionObserver(
    (entries) => {
      entries.forEach((entry) => {
        if (entry.isIntersecting) {
          entry.target.classList.add("fade-up-visible");
        }
      });
    },
    { threshold: 0.2 }
  );

  document.querySelectorAll(".fade-up").forEach((el) => {
    observer.observe(el);
  });

  // Animated Counter
  const counterObserver = new IntersectionObserver((entries) => {
    entries.forEach((entry) => {
      if (entry.isIntersecting) {
        const counters = entry.target.querySelectorAll('.counter');
        counters.forEach(counter => {
          const updateCount = () => {
            const target = +counter.getAttribute('data-target');
            const current = +counter.innerText;
            const increment = Math.ceil(target / 100);
            if (current < target) {
              counter.innerText = current + increment;
              setTimeout(updateCount, 40);
            } else {
              counter.innerText = target;
            }
          };
          updateCount();
        });
        counterObserver.unobserve(entry.target);
      }
    });
  }, { threshold: 0.3 });

  document.querySelectorAll('.counter-section').forEach(section => {
    counterObserver.observe(section);
  });
});

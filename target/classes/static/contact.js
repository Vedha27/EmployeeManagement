document.getElementById("contact-form").addEventListener("submit", async function (e) {
  e.preventDefault();

  const form = e.target;
  const formData = new FormData(form);
  const status = document.getElementById("form-status");

  try {
    const response = await fetch("https://formspree.io/f/xeokrjvo", {
      method: "POST",
      headers: { Accept: "application/json" },
      body: formData,
    });

    if (response.ok) {
      status.textContent = "✅ Thanks! Your message has been sent.";
      form.reset();
      status.style.color = "#00ffcc";
    } else {
      const data = await response.json();
      if (data.errors) {
        status.textContent = data.errors.map(error => error.message).join(", ");
      } else {
        status.textContent = "❌ Something went wrong. Please try again.";
      }
      status.style.color = "orange";
    }
  } catch (error) {
    status.textContent = "❌ Network error. Please try again.";
    status.style.color = "red";
  }
});

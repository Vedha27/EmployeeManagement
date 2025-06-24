// Sidebar Toggle
const menuBtn = document.getElementById('menuBtn');
const closeBtn = document.getElementById('closeBtn');
const sidebar = document.getElementById('sidebar');

menuBtn.onclick = () => sidebar.style.left = '0';
closeBtn.onclick = () => sidebar.style.left = '-250px';

// Auto-Slide Projects
let projectSlider = document.getElementById("projectSlider");
let currentIndex = 0;
setInterval(() => {
    currentIndex = (currentIndex + 1) % 4;
    projectSlider.style.transform = `translateX(-${currentIndex * 320}px)`;
}, 3000);

// Auto-Slide Testimonials
let testimonialSlider = document.getElementById("testimonialSlider");
let testimonialIndex = 0;
setInterval(() => {
    testimonialIndex = (testimonialIndex + 1) % 3;
    testimonialSlider.style.transform = `translateX(-${testimonialIndex * 100}%)`;
}, 4000);
// Open Modal
document.getElementById("openModal").addEventListener("click", function (e) {
  e.preventDefault();
  document.getElementById("employeeModal").style.display = "flex";
});

// Close Modal
document.getElementById("closeModal").addEventListener("click", () => {
  document.getElementById("employeeModal").style.display = "none";
});
document.getElementById("cancelModal").addEventListener("click", () => {
  document.getElementById("employeeModal").style.display = "none";
});
// Open Modal
document.getElementById("openModal").addEventListener("click", function (e) {
  e.preventDefault();
  document.getElementById("employeeModal").style.display = "flex";
});

// Close Modal
document.getElementById("closeModal").addEventListener("click", () => {
  document.getElementById("employeeModal").style.display = "none";
});
document.getElementById("cancelModal").addEventListener("click", () => {
  document.getElementById("employeeModal").style.display = "none";
});

// Submit Form
document.getElementById("employeeForm").addEventListener("submit", function (e) {
  e.preventDefault();
  const employee = {
    name: document.getElementById("empName").value,
    email: document.getElementById("empEmail").value,
    role: document.getElementById("empRole").value,
    department: document.getElementById("empDept").value
  };
  console.log("Submitted:", employee); // Replace with fetch() if needed
  alert("Employee added successfully!");
  this.reset();
  document.getElementById("employeeModal").style.display = "none";
});

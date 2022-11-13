export default function AuthHeader() {
  const user = JSON.parse(sessionStorage.getItem("currentUser"));

  if (user && user.accessToken) {
    // for Node.js Express back-end
    alert(user);
    alert(user.accessToken);
    return { "x-access-token": user.accessToken };
  } else {
    return {};
  }
}

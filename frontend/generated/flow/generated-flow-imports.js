import '@vaadin/common-frontend/ConnectionIndicator.js';
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import '@vaadin/vaadin-lumo-styles/color-global.js';
import '@vaadin/vaadin-lumo-styles/typography-global.js';
import '@vaadin/vaadin-lumo-styles/sizing.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/style.js';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset.js';

const loadOnDemand = (key) => {
  const pending = [];
  if (key === '7105b4a00a82e49d8e073fc6d7cdce927c7881d25fbe3b3143c92840d4d26b3c') {
    pending.push(import('./chunks/chunk-79969e720e0166c8c91d121521408a2b4385a83f490295d8a83cd2ef7d26a481.js'));
  }
  if (key === 'fb0a6fc8771f04580cfe7b2be40cc7d48c9e65919c25e151ded982cdac66f7de') {
    pending.push(import('./chunks/chunk-1805d86aeb5476b9cbcb62bbc54da617f37f51298eddbc594cf664a0d71f31a6.js'));
  }
  if (key === 'e7f83b6edd5baca2b903bd06511916b06fe9a68bcca1bfe2fe777134421b3215') {
    pending.push(import('./chunks/chunk-79969e720e0166c8c91d121521408a2b4385a83f490295d8a83cd2ef7d26a481.js'));
  }
  if (key === 'bb5913889aa2235d4bb5b26cd616ea91556276fa575ada3087d005f3e20afbf9') {
    pending.push(import('./chunks/chunk-79969e720e0166c8c91d121521408a2b4385a83f490295d8a83cd2ef7d26a481.js'));
  }
  if (key === '3d1f5af18d56997dbe56101800bf32793c014feacce73ea2ea5bad10c89e1e03') {
    pending.push(import('./chunks/chunk-79969e720e0166c8c91d121521408a2b4385a83f490295d8a83cd2ef7d26a481.js'));
  }
  if (key === 'c59d7808adfeb820334b3a77a43fe712b819bc474be68b96d5bfdd56a91db8fe') {
    pending.push(import('./chunks/chunk-79969e720e0166c8c91d121521408a2b4385a83f490295d8a83cd2ef7d26a481.js'));
  }
  return Promise.all(pending);
}

window.Vaadin = window.Vaadin || {};
window.Vaadin.Flow = window.Vaadin.Flow || {};
window.Vaadin.Flow.loadOnDemand = loadOnDemand;
window.Vaadin.Flow.resetFocus = () => {
 let ae=document.activeElement;
 while(ae&&ae.shadowRoot) ae = ae.shadowRoot.activeElement;
 return !ae || ae.blur() || ae.focus() || true;
}
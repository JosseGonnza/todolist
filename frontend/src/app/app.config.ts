import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { RouterLink, RouterModule, provideRouter } from '@angular/router';
import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideClientHydration(),
    importProvidersFrom(HttpClientModule),
    importProvidersFrom(CommonModule),
    provideHttpClient(),
    importProvidersFrom(FormsModule),
    importProvidersFrom(RouterModule.forRoot(routes)),
    importProvidersFrom(RouterLink)]
};

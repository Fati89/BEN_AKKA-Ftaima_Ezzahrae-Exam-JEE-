import { Routes } from '@angular/router';
import { AdminTemplate } from './admin-template/admin-template';
import { Client } from './client/client';

export const routes: Routes = [
  {
    path: 'admin', component: AdminTemplate,
    children: [
      { path: 'client', component: Client},
    ],
  },


];

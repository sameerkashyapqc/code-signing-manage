import { Component, OnInit } from '@angular/core';
import { ApiService } from '../core/api.service';

@Component({
  selector: 'app-certificate-list',
  templateUrl: './certificate-list.component.html'
})
export class CertificateListComponent implements OnInit {
  list: any[] = [];
  loading = true;
  err = '';

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.api.listCertificates().subscribe({
      next: (d) => { this.list = d; this.loading = false; },
      error: (e) => { this.err = 'Failed to load certificates'; this.loading = false; }
    });
  }
}

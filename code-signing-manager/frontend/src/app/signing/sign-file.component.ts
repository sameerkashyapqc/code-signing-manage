import { Component, OnInit } from '@angular/core';
import { ApiService } from '../core/api.service';

@Component({
  selector: 'app-signed-files',
  templateUrl: './signed-files.component.html'
})
export class SignedFilesComponent implements OnInit {
  list: any[] = [];
  loading = true;
  err = '';

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.api.listSignedFiles().subscribe({
      next: (d) => { this.list = d; this.loading = false; },
      error: () => { this.err = 'Failed to load signed files'; this.loading = false; }
    });
  }
}

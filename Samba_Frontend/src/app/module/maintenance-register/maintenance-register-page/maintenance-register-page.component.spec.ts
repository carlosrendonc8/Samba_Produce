import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintenanceRegisterPageComponent } from './maintenance-register-page.component';

describe('MaintenanceRegisterPageComponent', () => {
  let component: MaintenanceRegisterPageComponent;
  let fixture: ComponentFixture<MaintenanceRegisterPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MaintenanceRegisterPageComponent]
    });
    fixture = TestBed.createComponent(MaintenanceRegisterPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
